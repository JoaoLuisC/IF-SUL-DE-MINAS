# 📱 Controle Financeiro - Flutter

## 🎯 Sobre o Projeto

Este projeto é uma **migração completa** de um aplicativo Android Nativo (Java) para Flutter, desenvolvido como trabalho acadêmico do IF Sul de Minas. O aplicativo original era um sistema de controle financeiro pessoal com funcionalidades básicas de gerenciamento de contas a pagar e cotações de moedas.

### 🔄 Migração: Java → Flutter

| Aspecto | Android Nativo (Java) | Flutter (Dart) |
|---------|---------------------|----------------|
| **Linguagem** | Java | Dart |
| **UI** | XML Layouts | Widgets Declarativos |
| **Banco de Dados** | SQLiteOpenHelper | sqflite (async/await) |
| **HTTP** | Retrofit + Gson | Dio |
| **Estado** | notifyDataSetChanged() | Provider (ChangeNotifier) |
| **Persistência** | SharedPreferences | shared_preferences |
| **Arquitetura** | Activity/Fragment | Clean Architecture |

---

## ✨ Funcionalidades

### Implementadas do Original

1. **✅ Login com Autenticação**
   - Usuário/Senha fixos: `admin`/`admin`
   - "Manter conectado" com SharedPreferences
   - Logout funcional

2. **✅ Gestão de Contas a Pagar (Bills)**
   - Cadastro completo (Nome, Descrição, Valor, Data)
   - Listagem com ordenação por data
   - Exclusão com swipe (Dismissible)
   - Persistência em SQLite

3. **✅ Cotações de Moedas**
   - API: [AwesomeAPI](https://economia.awesomeapi.com.br)
   - 14 moedas suportadas (USD, EUR, BTC, etc.)
   - Atualização automática e manual
   - Exibição de máxima/mínima do dia

4. **✅ Transações Financeiras**
   - **FUNCIONALIDADE INCOMPLETA NO JAVA - IMPLEMENTADA DO ZERO!**
   - Cadastro de receitas e despesas
   - Categorização (Isenta/Não Isenta)
   - Cálculo de saldo automático

### 🚀 Funcionalidades Extras (Não estavam no original)

5. **🎨 Material Design 3**
   - Interface moderna e responsiva
   - Animações suaves
   - Cards com elevação

6. **🌙 Dark Mode**
   - Troca automática baseada no sistema
   - Tema claro e escuro completos

7. **📊 Gráfico de Gastos**
   - PieChart interativo (fl_chart)
   - Visualização de receitas vs despesas
   - Legenda com valores

8. **🏠 Dashboard Completo**
   - Resumo financeiro em tempo real
   - Navegação por cards clicáveis
   - Atualização pull-to-refresh

---

## 🏗️ Arquitetura do Projeto

```
lib/
├── main.dart                    # Entry point + Provider setup
├── models/                      # Camada de Dados
│   ├── bill.dart               # Modelo de Conta
│   ├── transaction.dart        # Modelo de Transação
│   └── currency.dart           # Modelo de Moeda
├── services/                    # Camada de Serviços
│   ├── database_helper.dart    # SQLite (Singleton)
│   ├── currency_service.dart   # API de Cotações
│   └── auth_service.dart       # Autenticação
├── providers/                   # Gerenciamento de Estado
│   ├── bill_provider.dart      # Estado de Contas
│   ├── transaction_provider.dart # Estado de Transações
│   └── currency_provider.dart  # Estado de Cotações
├── screens/                     # Telas da Aplicação
│   ├── login_screen.dart
│   ├── home_screen.dart
│   ├── bill_list_screen.dart
│   ├── add_bill_screen.dart
│   ├── transaction_list_screen.dart
│   ├── add_transaction_screen.dart
│   └── currencies_screen.dart
└── widgets/                     # Componentes Reutilizáveis
    ├── financial_summary_card.dart
    └── expense_chart.dart
```

### 🎨 Princípios Aplicados

- **Clean Code**: Código limpo, comentado e autoexplicativo
- **Single Responsibility**: Cada classe tem uma responsabilidade única
- **DRY (Don't Repeat Yourself)**: Reutilização de código
- **Separation of Concerns**: UI separada da lógica de negócio

---

## 🔧 Tecnologias e Dependências

### Core
- **Flutter SDK**: ^3.10.1
- **Dart**: Linguagem de programação

### Gerenciamento de Estado
- **provider**: ^6.1.1
  - *Por quê?* Simples, robusto e recomendado pela comunidade Flutter
  - *Alternativa no Java:* Nenhuma (callbacks manuais)

### Banco de Dados Local
- **sqflite**: ^2.3.0
  - *Por quê?* SQLite nativo com async/await
  - *Substitui:* SQLiteOpenHelper (Java)
- **path**: ^1.9.0
  - *Por quê?* Gerenciamento de caminhos de arquivos

### Requisições HTTP
- **dio**: ^5.4.0
  - *Por quê?* Mais simples e poderoso que o http básico
  - *Substitui:* Retrofit (Java)
  - *Vantagem:* Sem geração de código, configuração direta

### Persistência
- **shared_preferences**: ^2.2.2
  - *Por quê?* Armazenamento key-value simples
  - *Equivalente:* SharedPreferences (Java)

### Gráficos
- **fl_chart**: ^0.66.0
  - *Por quê?* Biblioteca de gráficos mais popular do Flutter
  - *Não tinha no Java!* Funcionalidade extra

### UI
- **font_awesome_flutter**: ^10.6.0
  - *Por quê?* Ícones modernos e consistentes

### Utilitários
- **intl**: ^0.19.0
  - *Por quê?* Formatação de datas e números

---

## 📦 Como Executar

### Pré-requisitos
- Flutter SDK instalado ([Guia oficial](https://flutter.dev/docs/get-started/install))
- Emulador Android/iOS ou dispositivo físico
- Editor (VS Code ou Android Studio)

### Passo a Passo

1. **Clone o repositório**
```bash
git clone <seu-repositorio>
cd flutter_application_2
```

2. **Instale as dependências**
```bash
flutter pub get
```

3. **Execute o app**
```bash
flutter run
```

4. **Login**
- Usuário: `admin`
- Senha: `admin`

---

## 🎓 Decisões Técnicas (Para a Wiki)

### 1. Por que Provider e não setState direto?

**Problema no Java:**
No Android Nativo, atualizávamos a UI manualmente com `notifyDataSetChanged()` no Adapter. Isso criava acoplamento entre dados e UI.

**Solução Flutter:**
- Provider separa lógica de negócio da UI
- `notifyListeners()` atualiza automaticamente todos os ouvintes
- Testabilidade: Provider pode ser testado independentemente

### 2. Por que Dio em vez de Retrofit?

**Java/Retrofit:**
```java
@GET("last/USD-BRL")
Call<Map<String, Currency>> getRates();
```
- Precisa de annotations
- Geração de código
- Verboso

**Flutter/Dio:**
```dart
await _dio.get('/last/USD-BRL');
```
- Direto e simples
- Sem geração de código
- Async/await nativo

### 3. Por que sqflite em vez de SQLiteOpenHelper?

**Java/SQLiteOpenHelper:**
```java
ContentValues values = new ContentValues();
values.put("name", bill.getName());
db.insert("bills", null, values);
```

**Flutter/sqflite:**
```dart
await db.insert('bills', bill.toMap());
```
- Menos código
- Async/await (não bloqueia UI)
- API mais limpa

### 4. Como funciona o Singleton no DatabaseHelper?

**Pattern:**
```dart
static final DatabaseHelper _instance = DatabaseHelper._internal();
factory DatabaseHelper() => _instance;
```

**Vantagem:**
- Única instância do banco em toda a aplicação
- Economia de recursos
- Thread-safe

---

## 📊 Comparação de Código

### Exemplo 1: Inserir no Banco

**Java (Verboso):**
```java
SQLiteDatabase db = dbHelper.getWritableDatabase();
ContentValues values = new ContentValues();
values.put("name", bill.getName());
values.put("description", bill.getDescription());
values.put("value", bill.getValue());
values.put("date", bill.getDate());
long id = db.insert("bills", null, values);
db.close();
```

**Flutter (Conciso):**
```dart
await _db.insert('bills', bill.toMap());
```

### Exemplo 2: Requisição HTTP

**Java (Retrofit - Callback Hell):**
```java
call.enqueue(new Callback<Map<String, Currency>>() {
    @Override
    public void onResponse(Call<Map<String, Currency>> call, Response<Map<String, Currency>> response) {
        if (response.isSuccessful()) {
            currencies = response.body();
            updateUI();
        }
    }
    @Override
    public void onFailure(Call<Map<String, Currency>> call, Throwable t) {
        showError(t.getMessage());
    }
});
```

**Flutter (Async/Await - Limpo):**
```dart
try {
  final response = await _dio.get('/last/$currencies');
  _currencies = _parseCurrencies(response.data);
  notifyListeners();
} catch (e) {
  _error = 'Erro: $e';
  notifyListeners();
}
```

---

## 🐛 Troubleshooting

### Erro: "MissingPluginException"
**Solução:** Execute `flutter clean` e `flutter pub get`

### Erro: "Dio connection timeout"
**Causa:** API AwesomeAPI pode estar lenta
**Solução:** Aumentar timeout em `currency_service.dart`

### Banco de dados não persiste
**Solução:** Verifique permissões no AndroidManifest.xml

---

## 📝 Melhorias Futuras

- [ ] Autenticação real com Firebase
- [ ] Categorias customizáveis de transações
- [ ] Exportação de relatórios em PDF
- [ ] Backup na nuvem
- [ ] Notificações de vencimento de contas
- [ ] Multi-idioma (i18n)
- [ ] Biometria (fingerprint/face)

---

## 👥 Autor

Desenvolvido como trabalho acadêmico para IF Sul de Minas  
Migração: Android Nativo (Java) → Flutter (Dart)

---

## 📄 Licença

Este projeto é de uso educacional.

---

## 🎉 Agradecimentos

- **Projeto Original:** ControleFinanceiro (Java)
- **API de Cotações:** [AwesomeAPI](https://economia.awesomeapi.com.br)
- **Comunidade Flutter:** Documentação e exemplos
