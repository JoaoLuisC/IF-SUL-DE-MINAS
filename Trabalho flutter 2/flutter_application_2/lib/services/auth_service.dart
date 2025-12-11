import 'package:shared_preferences/shared_preferences.dart';

/// AuthService - Serviço de Autenticação
///
/// Migrado de: MainActivity.java (Java) - lógica de SharedPreferences
///
/// **DIFERENÇAS DO JAVA:**
///
/// 1. **SharedPreferences:**
///    - Java: getSharedPreferences("nome", MODE_PRIVATE)
///    - Flutter: SharedPreferences.getInstance() (async)
///
/// 2. **Type Safety:**
///    - Java: getString(), getBoolean() podem retornar null
///    - Flutter: Métodos com null safety integrado
///
/// 3. **Arquitetura:**
///    - Java: Lógica espalhada nas Activities
///    - Flutter: Centralizada em um serviço (Single Responsibility)
class AuthService {
  static const String _keyIsRemembered = 'isRemembered';
  static const String _keyUsername = 'rememberedUsername';

  // Credenciais fixas (como no projeto original)
  static const String _defaultUsername = 'admin';
  static const String _defaultPassword = 'admin';

  /// Verifica se o usuário já está logado (Manter Conectado)
  ///
  /// **Uso:**
  /// ```dart
  /// if (await authService.isUserRemembered()) {
  ///   // Vai direto para HomeScreen
  /// } else {
  ///   // Mostra LoginScreen
  /// }
  /// ```
  Future<bool> isUserRemembered() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getBool(_keyIsRemembered) ?? false;
  }

  /// Retorna o nome de usuário salvo (se existir)
  Future<String?> getRememberedUsername() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getString(_keyUsername);
  }

  /// Valida credenciais de login
  ///
  /// **No projeto original (Java):**
  /// ```java
  /// if (username.equals("admin") && password.equals("admin")) { ... }
  /// ```
  ///
  /// **Retorna:**
  /// - `true`: Login válido
  /// - `false`: Credenciais inválidas
  bool validateCredentials(String username, String password) {
    return username == _defaultUsername && password == _defaultPassword;
  }

  /// Realiza o login e salva preferências
  ///
  /// **Parâmetros:**
  /// - `username`: Nome de usuário
  /// - `password`: Senha
  /// - `rememberMe`: Se deve manter conectado
  ///
  /// **Retorna:**
  /// - `true`: Login bem-sucedido
  /// - `false`: Credenciais inválidas
  Future<bool> login({
    required String username,
    required String password,
    bool rememberMe = false,
  }) async {
    // Valida credenciais
    if (!validateCredentials(username, password)) {
      return false;
    }

    // Salva preferências se "Lembrar de mim" estiver marcado
    final prefs = await SharedPreferences.getInstance();

    if (rememberMe) {
      await prefs.setBool(_keyIsRemembered, true);
      await prefs.setString(_keyUsername, username);
    } else {
      // Limpa preferências anteriores
      await prefs.remove(_keyIsRemembered);
      await prefs.remove(_keyUsername);
    }

    return true;
  }

  /// Realiza logout (remove preferências)
  ///
  /// **Diferença do Java:**
  /// No Java não tinha logout explícito. Adicionamos aqui como boa prática.
  Future<void> logout() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.remove(_keyIsRemembered);
    await prefs.remove(_keyUsername);
  }

  /// Limpa todas as preferências (útil para testes)
  Future<void> clearAll() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.clear();
  }
}
