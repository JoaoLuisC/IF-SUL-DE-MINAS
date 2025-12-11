import 'package:flutter/material.dart';

/// Definição centralizada do tema da aplicação.
///
/// Separa a configuração visual do restante da lógica,
/// facilitando manutenção e personalização futura.
class AppTheme {
  // Paleta de cores educacionais - tons suaves e motivadores
  static const Color primaryColor = Color(0xFF6200EE); // Roxo vibrante
  static const Color secondaryColor = Color(0xFF03DAC6); // Ciano
  static const Color backgroundColor = Color(0xFFF5F5F5); // Cinza claro
  static const Color surfaceColor = Color(0xFFFFFFFF); // Branco
  static const Color errorColor = Color(0xFFB00020); // Vermelho
  static const Color successColor = Color(0xFF4CAF50); // Verde

  // Cores para flashcards
  static const Color flashcardFrontColor = Color(0xFF6200EE);
  static const Color flashcardBackColor = Color(0xFF03DAC6);

  /// Retorna o tema claro da aplicação
  static ThemeData get lightTheme {
    return ThemeData(
      // Configuração do Material 3
      useMaterial3: true,

      // Esquema de cores
      colorScheme: ColorScheme.light(
        primary: primaryColor,
        secondary: secondaryColor,
        surface: surfaceColor,
        error: errorColor,
      ),

      // Cor de fundo padrão
      scaffoldBackgroundColor: backgroundColor,

      // Configuração da AppBar
      appBarTheme: const AppBarTheme(
        elevation: 0,
        centerTitle: true,
        backgroundColor: primaryColor,
        foregroundColor: Colors.white,
        titleTextStyle: TextStyle(
          fontSize: 20,
          fontWeight: FontWeight.bold,
          color: Colors.white,
        ),
      ),

      // Configuração de Cards
      cardTheme: CardThemeData(
        elevation: 2,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
      ),

      // Configuração de botões elevados
      elevatedButtonTheme: ElevatedButtonThemeData(
        style: ElevatedButton.styleFrom(
          backgroundColor: primaryColor,
          foregroundColor: Colors.white,
          padding: const EdgeInsets.symmetric(horizontal: 32, vertical: 16),
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
          textStyle: const TextStyle(fontSize: 16, fontWeight: FontWeight.w600),
        ),
      ),

      // Configuração de botões de texto
      textButtonTheme: TextButtonThemeData(
        style: TextButton.styleFrom(
          foregroundColor: primaryColor,
          textStyle: const TextStyle(fontSize: 16, fontWeight: FontWeight.w600),
        ),
      ),

      // Configuração de tipografia
      textTheme: const TextTheme(
        displayLarge: TextStyle(
          fontSize: 32,
          fontWeight: FontWeight.bold,
          color: Colors.black87,
        ),
        displayMedium: TextStyle(
          fontSize: 28,
          fontWeight: FontWeight.bold,
          color: Colors.black87,
        ),
        displaySmall: TextStyle(
          fontSize: 24,
          fontWeight: FontWeight.bold,
          color: Colors.black87,
        ),
        headlineMedium: TextStyle(
          fontSize: 20,
          fontWeight: FontWeight.w600,
          color: Colors.black87,
        ),
        bodyLarge: TextStyle(fontSize: 16, color: Colors.black87),
        bodyMedium: TextStyle(fontSize: 14, color: Colors.black87),
      ),
    );
  }
}
