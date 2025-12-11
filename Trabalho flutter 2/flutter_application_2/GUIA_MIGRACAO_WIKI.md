# 📚 Guia de Migração: Android Java → Flutter

## 🎯 Introdução

Este documento detalha **TODAS** as decisões técnicas tomadas na migração do aplicativo "Controle Financeiro" de Android Nativo (Java) para Flutter (Dart).

---

## 📋 Índice

1. [Arquitetura](#1-arquitetura)
2. [Banco de Dados](#2-banco-de-dados)
3. [Gerenciamento de Estado](#3-gerenciamento-de-estado)
4. [Requisições HTTP](#4-requisições-http)
5. [Navegação](#5-navegação)
6. [Interface do Usuário](#6-interface-do-usuário)
7. [Vantagens do Flutter](#7-vantagens-do-flutter)

---

## 1. Arquitetura

### 🏢 Antes (Java)

```
app/src/main/java/br/edu/ifsuldeminas/mch/controlefinanceiro/
├── MainActivity.java           # Login + lógica
├── MenuActivity.java           # Menu + lógica
├── ListBillsActivity.java      # Lista + lógica
├── AddBillsActivity.java       # Form + lógica
├── CoinsActivity.java          # Cotações + lógica
└── model/
    ├── Bill.java               # POJO
    ├── Transaction.java        # POJO
    ├── Currency.java           # POJO
    └── db/
        ├── DBHandler.java      # SQLite
        └── BillDAO.java        # CRUD
```

**Problemas:**
- Lógica misturada com UI nas Activities
- Difícil de testar
- Acoplamento alto
- Repetição de código

### ✅ Depois (Flutter)

```
lib/
├── main.dart                   # Setup inicial
├── models/                     # APENAS dados
│   ├── bill.dart
│   ├── transaction.dart
│   └── currency.dart
├── services/                   # APENAS lógica de negócio
│   ├── database_helper.dart
│   ├── currency_service.dart
│   └── auth_service.dart
├── providers/                  # APENAS estado
│   ├── bill_provider.dart
│   ├── transaction_provider.dart
│   └── currency_provider.dart
└── screens/                    # APENAS UI
    ├── login_screen.dart
    ├── home_screen.dart
    └── ...
```

**Vantagens:**
- Separação clara de responsabilidades
- Cada camada testável independentemente
- Baixo acoplamento
- Reutilização de código

---

## 2. Banco de Dados

### 📝 Antes (Java/SQLiteOpenHelper)

```java
public class DBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "financial.db";
    private static final int DATABASE_VERSION = 1;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE bills (...);");
    }
}

// Inserir dado
public void insertBill(Bill bill) {
    SQLiteDatabase db = getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("name", bill.getName());
    values.put("description", bill.getDescription());
    values.put("value", bill.getValue());
    values.put("date", bill.getDate());
    db.insert("bills", null, values);
    db.close(); // ⚠️ Tem que fechar manualmente!
}

// Buscar dados
public List<Bill> getAllBills() {
    List<Bill> bills = new ArrayList<>();
    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.rawQuery("SELECT * FROM bills", null);
    
    if (cursor.moveToFirst()) {
        do {
            Bill bill = new Bill();
            bill.setId(cursor.getInt(0));
            bill.setName(cursor.getString(1));
            // ... mais 4 campos
            bills.add(bill);
        } while (cursor.moveToNext());
    }
    cursor.close();
    db.close();
    return bills;
}
```

**Problemas:**
- Muito código boilerplate
- ContentValues verboso
- Cursor manual
- Síncrono (bloqueia UI)
- Gerenciamento manual de conexões

### ✅ Depois (Flutter/sqflite)

```dart
class DatabaseHelper {
  static final DatabaseHelper _instance = DatabaseHelper._internal();
  factory DatabaseHelper() => _instance; // Singleton!
  static Database? _database;

  Future<Database> get database async {
    if (_database != null) return _database!;
    _database = await _initDatabase();
    return _database!;
  }

  Future<Database> _initDatabase() async {
    final path = join(await getDatabasesPath(), 'financial.db');
    return await openDatabase(
      path,
      version: 2,
      onCreate: (db, version) async {
        await db.execute('CREATE TABLE bills (...)');
        await db.execute('CREATE TABLE transactions (...)');
      },
    );
  }

  // Inserir dado - 1 linha! 🎉
  Future<int> insertBill(Bill bill) async {
    final db = await database;
    return await db.insert('bills', bill.toMap());
  }

  // Buscar dados - simples e limpo
  Future<List<Bill>> getAllBills() async {
    final db = await database;
    final maps = await db.query('bills', orderBy: 'date DESC');
    return List.generate(maps.length, (i) => Bill.fromMap(maps[i]));
  }
}
```

**Vantagens:**
- ✅ **Singleton Pattern**: Uma única instância do banco
- ✅ **Async/Await**: Não bloqueia a UI
- ✅ **Menos código**: 90% menos boilerplate
- ✅ **Type Safety**: Usa Map<String, dynamic>
- ✅ **Auto-gerenciamento**: Não precisa fechar conexão

### 🔍 Por que usar Singleton?

```dart
// ❌ SEM Singleton
final db1 = DatabaseHelper(); // Cria nova instância
final db2 = DatabaseHelper(); // Cria OUTRA instância
// Problema: Múltiplas conexões = desperdício de memória

// ✅ COM Singleton
final db1 = DatabaseHelper(); // Cria instância
final db2 = DatabaseHelper(); // Retorna a MESMA instância
// Solução: Uma única conexão compartilhada
```

---

## 3. Gerenciamento de Estado

### 🔄 Antes (Java)

**Cenário:** Lista de contas. Quando adiciona nova conta, precisa atualizar a tela.

```java
public class ListBillsActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<Bill> adapter;
    private List<Bill> bills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_bills);
        
        listView = findViewById(R.id.listView);
        bills = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bills);
        listView.setAdapter(adapter);
        
        loadBills();
    }

    private void loadBills() {
        BillDAO dao = new BillDAO(this);
        bills.clear();
        bills.addAll(dao.getAllBills());
        adapter.notifyDataSetChanged(); // ⚠️ Atualização manual!
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadBills(); // ⚠️ Tem que chamar manualmente!
    }
}

// Na Activity de adicionar:
public class AddBillsActivity extends AppCompatActivity {
    private void saveBill() {
        BillDAO dao = new BillDAO(this);
        dao.insert(bill);
        finish(); // Volta para lista
        // ⚠️ Lista atualiza no onResume()
    }
}
```

**Problemas:**
- Atualização manual com `notifyDataSetChanged()`
- Lógica espalhada (Activity + DAO)
- Difícil de testar
- Estado não compartilhado entre telas

### ✅ Depois (Flutter/Provider)

```dart
// 1️⃣ Provider: Gerencia Estado + Lógica
class BillProvider with ChangeNotifier {
  final DatabaseHelper _db = DatabaseHelper();
  List<Bill> _bills = [];
  bool _isLoading = false;

  List<Bill> get bills => _bills;
  bool get isLoading => _isLoading;

  Future<void> loadBills() async {
    _isLoading = true;
    notifyListeners(); // 🔔 Avisa: "Tô carregando!"
    
    _bills = await _db.getAllBills();
    
    _isLoading = false;
    notifyListeners(); // 🔔 Avisa: "Terminei de carregar!"
  }

  Future<void> addBill(Bill bill) async {
    await _db.insertBill(bill);
    await loadBills(); // Recarrega automaticamente
    // notifyListeners() já foi chamado em loadBills()
  }
}

// 2️⃣ UI: APENAS consome o estado
class BillListScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Contas')),
      body: Consumer<BillProvider>(
        builder: (context, provider, child) {
          if (provider.isLoading) {
            return Center(child: CircularProgressIndicator());
          }
          
          return ListView.builder(
            itemCount: provider.bills.length,
            itemBuilder: (context, index) {
              final bill = provider.bills[index];
              return ListTile(title: Text(bill.name));
            },
          );
        },
      ),
    );
  }
}

// 3️⃣ Adicionar: Atualiza automaticamente!
class AddBillScreen extends StatelessWidget {
  Future<void> _save(BuildContext context) async {
    await context.read<BillProvider>().addBill(bill);
    Navigator.pop(context); // Volta para lista
    // ✨ Lista atualiza AUTOMATICAMENTE!
  }
}
```

**Vantagens:**
- ✅ **Reatividade**: UI atualiza automaticamente
- ✅ **Separação**: Lógica separada da UI
- ✅ **Compartilhamento**: Mesmo estado em múltiplas telas
- ✅ **Testabilidade**: Provider testável sem UI

### 🎯 Como funciona o notifyListeners()?

```dart
// Imagine que Provider é um "gerente" que avisa todos os "funcionários" (widgets)

class BillProvider with ChangeNotifier {
  List<Bill> _bills = [];
  
  Future<void> addBill(Bill bill) async {
    await _db.insert(bill);
    _bills.add(bill);
    
    notifyListeners(); // 📢 "EI PESSOAL! A LISTA MUDOU!"
    // Todos os Consumer<BillProvider> ouvem e reconstruem
  }
}

// Na UI:
Consumer<BillProvider>( // 👂 "Eu tô ouvindo!"
  builder: (context, provider, child) {
    // Sempre que notifyListeners() for chamado,
    // este builder roda de novo automaticamente!
    return ListView(...); 
  },
)
```

---

## 4. Requisições HTTP

### 🌐 Antes (Java/Retrofit)

```java
// 1️⃣ Interface com annotations
public interface CurrencyService {
    @GET("last/{currencies}")
    Call<Map<String, Currency>> getExchangeRates(@Path("currencies") String currencies);
}

// 2️⃣ Setup do Retrofit (muito código!)
Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("https://economia.awesomeapi.com.br/")
    .addConverterFactory(GsonConverterFactory.create())
    .build();

CurrencyService service = retrofit.create(CurrencyService.class);

// 3️⃣ Fazer requisição (Callback Hell)
Call<Map<String, Currency>> call = service.getExchangeRates("USD-BRL,EUR-BRL");

call.enqueue(new Callback<Map<String, Currency>>() {
    @Override
    public void onResponse(Call<Map<String, Currency>> call, Response<Map<String, Currency>> response) {
        if (response.isSuccessful()) {
            Map<String, Currency> data = response.body();
            // Processar dados...
            runOnUiThread(() -> updateUI(data));
        } else {
            Log.e("API", "Erro: " + response.code());
        }
    }

    @Override
    public void onFailure(Call<Map<String, Currency>> call, Throwable t) {
        Log.e("API", "Falha: " + t.getMessage());
        runOnUiThread(() -> showError(t.getMessage()));
    }
});
```

**Problemas:**
- Muito boilerplate (annotations, builders)
- Callback hell (difícil de ler)
- `runOnUiThread()` manual
- Geração de código necessária

### ✅ Depois (Flutter/Dio)

```dart
class CurrencyService {
  final Dio _dio = Dio(BaseOptions(
    baseUrl: 'https://economia.awesomeapi.com.br',
    connectTimeout: Duration(seconds: 10),
  ));

  Future<List<Currency>> getExchangeRates() async {
    try {
      final response = await _dio.get('/last/USD-BRL,EUR-BRL');
      
      final Map<String, dynamic> data = response.data;
      return data.entries.map((e) => Currency.fromJson(e.value)).toList();
      
    } on DioException catch (e) {
      throw CurrencyServiceException('Erro de rede: ${e.message}');
    }
  }
}

// Usar na UI
Future<void> _loadCurrencies() async {
  try {
    final currencies = await _service.getExchangeRates();
    setState(() => _currencies = currencies);
  } catch (e) {
    showError(e.toString());
  }
}
```

**Vantagens:**
- ✅ **Async/Await**: Código linear e legível
- ✅ **Sem annotations**: Configuração direta
- ✅ **Sem geração de código**: Funciona imediatamente
- ✅ **Try/Catch**: Tratamento de erro natural
- ✅ **Automático**: setState() já atualiza UI

### 📊 Comparação Lado a Lado

| Aspecto | Retrofit (Java) | Dio (Flutter) |
|---------|-----------------|---------------|
| Linhas de código | ~40 | ~10 |
| Geração de código | Sim | Não |
| Callbacks | Sim (aninhados) | Não (async/await) |
| Thread management | Manual (runOnUiThread) | Automático |
| Legibilidade | 😐 Média | 😊 Alta |

---

## 5. Navegação

### 🗺️ Antes (Java/Intent)

```java
// De LoginActivity para MenuActivity
Intent intent = new Intent(MainActivity.this, MenuActivity.class);
intent.putExtra("USERNAME", username);
startActivity(intent);
finish(); // Remove da pilha

// De MenuActivity para ListBillsActivity
Intent intent = new Intent(MenuActivity.this, ListBillsActivity.class);
startActivity(intent);

// Voltar
finish();

// Passar dados de volta (resultado)
Intent resultIntent = new Intent();
resultIntent.putExtra("BILL_ID", billId);
setResult(RESULT_OK, resultIntent);
finish();

// Receber resultado
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == ADD_BILL_REQUEST && resultCode == RESULT_OK) {
        int billId = data.getIntExtra("BILL_ID", -1);
        refreshList();
    }
}
```

**Problemas:**
- Verboso (Intent + extras + request codes)
- Sem type safety (String keys)
- `onActivityResult()` confuso

### ✅ Depois (Flutter/Navigator)

```dart
// Ir para outra tela
Navigator.push(
  context,
  MaterialPageRoute(builder: (context) => HomeScreen()),
);

// Ir e remover anterior
Navigator.pushReplacement(
  context,
  MaterialPageRoute(builder: (context) => LoginScreen()),
);

// Voltar
Navigator.pop(context);

// Passar dados (type safe!)
Navigator.push(
  context,
  MaterialPageRoute(
    builder: (context) => AddBillScreen(bill: selectedBill),
  ),
);

// Aguardar resultado
final result = await Navigator.push<bool>(
  context,
  MaterialPageRoute(builder: (context) => AddBillScreen()),
);

if (result == true) {
  // Refresh
}
```

**Vantagens:**
- ✅ **Type Safety**: Pode retornar qualquer tipo
- ✅ **Async/Await**: Aguarda resultado naturalmente
- ✅ **Menos código**: Sem request codes
- ✅ **Limpo**: Sem extras com chaves String

---

## 6. Interface do Usuário

### 🎨 Antes (Java/XML)

```xml
<!-- activity_login.xml -->
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:id="@+id/title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Controle Financeiro"
        android:textSize="24sp"
        android:textStyle="bold" />

    <EditText
        android:id="@+id/usernameInput"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Usuário" />

    <EditText
        android:id="@+id/passwordInput"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Senha"
        android:inputType="textPassword" />

    <Button
        android:id="@+id/loginButton"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Entrar" />
</LinearLayout>
```

```java
// MainActivity.java
public class MainActivity extends AppCompatActivity {
    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();
            // ...
        });
    }
}
```

**Problemas:**
- UI separada da lógica (XML vs Java)
- findViewById() manual
- Sem hot reload

### ✅ Depois (Flutter/Widgets)

```dart
class LoginScreen extends StatefulWidget {
  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final _usernameController = TextEditingController();
  final _passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: EdgeInsets.all(16),
        child: Column(
          children: [
            Text(
              'Controle Financeiro',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            TextField(
              controller: _usernameController,
              decoration: InputDecoration(labelText: 'Usuário'),
            ),
            TextField(
              controller: _passwordController,
              decoration: InputDecoration(labelText: 'Senha'),
              obscureText: true,
            ),
            ElevatedButton(
              onPressed: () {
                final username = _usernameController.text;
                final password = _passwordController.text;
                // ...
              },
              child: Text('Entrar'),
            ),
          ],
        ),
      ),
    );
  }
}
```

**Vantagens:**
- ✅ **Tudo em um lugar**: UI + lógica no mesmo arquivo
- ✅ **Hot Reload**: Vê mudanças instantaneamente
- ✅ **Composição**: Widgets dentro de widgets
- ✅ **Type Safe**: Erros em tempo de compilação

---

## 7. Vantagens do Flutter

### ⚡ Hot Reload

**Java:**
```
Mudar código → Compile (30s) → Instalar APK (20s) → Reabrir app (10s)
Total: ~1 minuto para cada mudança 😴
```

**Flutter:**
```
Mudar código → Ctrl+S → Hot Reload (1s)
Total: 1 segundo! 🚀
```

### 🎨 Material Design 3

**Java:**
- Precisa atualizar bibliotecas manualmente
- Inconsistências entre versões do Android
- Customização complexa

**Flutter:**
- Material 3 built-in
- Funciona em todas as versões
- Customização fácil:
```dart
ThemeData(
  useMaterial3: true,
  colorScheme: ColorScheme.fromSeed(seedColor: Colors.blue),
)
```

### 🌙 Dark Mode

**Java:**
- Precisa criar arquivos `values-night/`
- Duplicar todos os XMLs de layout
- Testar em cada versão do Android

**Flutter:**
```dart
MaterialApp(
  theme: ThemeData.light(),
  darkTheme: ThemeData.dark(),
  themeMode: ThemeMode.system, // Automático!
)
```

---

## 📊 Resumo Final

| Aspecto | Java (Android Nativo) | Flutter |
|---------|----------------------|---------|
| Linhas de código | ~2000 | ~800 |
| Tempo de build | ~1 min | <10s |
| Hot reload | ❌ | ✅ |
| Single codebase (iOS/Android) | ❌ | ✅ |
| Curva de aprendizado | Alta | Média |
| Performance | Nativa | Quase nativa |
| Comunidade | Grande | Crescendo rápido |

---

## 🎓 Conclusão

**Por que migrar para Flutter?**

1. **Produtividade:** Código 60% menor
2. **Manutenibilidade:** Arquitetura mais limpa
3. **Cross-platform:** iOS + Android com mesmo código
4. **Moderna:** Material Design 3, Dark Mode, etc.
5. **Developer Experience:** Hot reload, widgets compostos

**Quando NÃO usar Flutter:**
- Apps com muita manipulação de hardware específico
- Projetos legados grandes (migração cara)
- Time já expert em Java/Kotlin

---

**Para a Wiki:** Use este documento como base e adicione prints de tela comparando as interfaces!
