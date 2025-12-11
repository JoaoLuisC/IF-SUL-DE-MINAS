import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'providers/bill_provider.dart';
import 'providers/transaction_provider.dart';
import 'providers/currency_provider.dart';
import 'services/auth_service.dart';
import 'screens/login_screen.dart';
import 'screens/home_screen.dart';

/// Aplicativo de Controle Financeiro
///
/// **MIGRAÇÃO DE ANDROID NATIVO (JAVA) PARA FLUTTER**
///
/// Projeto Original: br.edu.ifsuldeminas.mch.controlefinanceiro
/// Tecnologia Original: Android Nativo com Java + SQLite + Retrofit
///
/// Nova Implementação:
/// - Flutter com Dart
/// - Arquitetura: Clean Code + Provider Pattern
/// - Material Design 3
/// - Dark Mode Support
///
/// **PRINCIPAIS MELHORIAS:**
///
/// 1. **Gerenciamento de Estado:**
///    - Java: Callbacks manuais e notifyDataSetChanged()
///    - Flutter: Provider com reatividade automática
///
/// 2. **Banco de Dados:**
///    - Java: SQLiteOpenHelper verboso
///    - Flutter: sqflite com async/await limpo
///
/// 3. **Requisições HTTP:**
///    - Java: Retrofit com muito boilerplate
///    - Flutter: Dio simples e direto
///
/// 4. **UI:**
///    - Java: XML layouts estáticos
///    - Flutter: Widgets compostos e reativos
///
/// 5. **Funcionalidades Extras:**
///    - Gráfico de gastos (PieChart)
///    - Dark Mode
///    - Transações completas (estava incompleto no Java)
void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    // MultiProvider: Disponibiliza os Providers para toda a árvore de widgets
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => BillProvider()),
        ChangeNotifierProvider(create: (_) => TransactionProvider()),
        ChangeNotifierProvider(create: (_) => CurrencyProvider()),
      ],
      child: MaterialApp(
        title: 'Controle Financeiro',
        debugShowCheckedModeBanner: false,

        // Tema Claro (Material 3)
        theme: ThemeData(
          useMaterial3: true,
          colorScheme: ColorScheme.fromSeed(
            seedColor: Colors.blue,
            brightness: Brightness.light,
          ),
          cardTheme: const CardThemeData(
            elevation: 2,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.all(Radius.circular(12)),
            ),
          ),
          inputDecorationTheme: const InputDecorationTheme(
            border: OutlineInputBorder(
              borderRadius: BorderRadius.all(Radius.circular(8)),
            ),
          ),
        ),

        // Tema Escuro (Material 3) - Funcionalidade Extra!
        darkTheme: ThemeData(
          useMaterial3: true,
          colorScheme: ColorScheme.fromSeed(
            seedColor: Colors.blue,
            brightness: Brightness.dark,
          ),
          cardTheme: const CardThemeData(
            elevation: 2,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.all(Radius.circular(12)),
            ),
          ),
          inputDecorationTheme: const InputDecorationTheme(
            border: OutlineInputBorder(
              borderRadius: BorderRadius.all(Radius.circular(8)),
            ),
          ),
        ),

        // Detecta preferência do sistema
        themeMode: ThemeMode.system,

        // Tela Inicial: Verifica se usuário está logado
        home: const AuthChecker(),
      ),
    );
  }
}

/// Widget que verifica autenticação ao iniciar o app
///
/// **Como funciona:**
/// 1. Verifica SharedPreferences se usuário marcou "Manter Conectado"
/// 2. Se sim -> vai direto para HomeScreen
/// 3. Se não -> mostra LoginScreen
///
/// **No Java:**
/// Isso era feito no onCreate() da MainActivity.
/// Aqui isolamos em um widget específico (melhor arquitetura).
class AuthChecker extends StatefulWidget {
  const AuthChecker({super.key});

  @override
  State<AuthChecker> createState() => _AuthCheckerState();
}

class _AuthCheckerState extends State<AuthChecker> {
  final _authService = AuthService();
  bool _isChecking = true;
  bool _isLoggedIn = false;

  @override
  void initState() {
    super.initState();
    _checkAuth();
  }

  Future<void> _checkAuth() async {
    final isRemembered = await _authService.isUserRemembered();
    setState(() {
      _isLoggedIn = isRemembered;
      _isChecking = false;
    });
  }

  @override
  Widget build(BuildContext context) {
    // Mostra loading enquanto verifica
    if (_isChecking) {
      return const Scaffold(body: Center(child: CircularProgressIndicator()));
    }

    // Retorna tela apropriada
    return _isLoggedIn ? const HomeScreen() : const LoginScreen();
  }
}
