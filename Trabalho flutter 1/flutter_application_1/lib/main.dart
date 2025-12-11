import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:provider/provider.dart';
import 'core/theme/app_theme.dart';
import 'core/routes/app_routes.dart';
import 'core/localization/app_localizations.dart';
import 'core/localization/locale_provider.dart';
import 'features/home/screens/home_screen.dart';
import 'features/credits/screens/credits_screen.dart';
import 'features/modules/screens/modules_list_screen.dart';
import 'features/modules/screens/learning_module_screen.dart';
import 'features/quiz/screens/quiz_screen.dart';
import 'features/quiz/screens/quiz_result_screen.dart';

/// Ponto de entrada da aplicação.
///
/// ARQUITETURA: Mantém a configuração mínima no main.dart,
/// delegando tema, rotas e lógica para arquivos específicos.
void main() {
  runApp(
    ChangeNotifierProvider(
      create: (_) => LocaleProvider(),
      child: const EnglishLearningApp(),
    ),
  );
}

/// Widget raiz da aplicação.
///
/// Configura o MaterialApp com tema personalizado e sistema de rotas nomeadas.
/// StatelessWidget pois não mantém estado próprio.
class EnglishLearningApp extends StatelessWidget {
  const EnglishLearningApp({super.key});

  @override
  Widget build(BuildContext context) {
    return Consumer<LocaleProvider>(
      builder: (context, localeProvider, child) {
        return MaterialApp(
          // Configurações gerais
          title: 'English for Beginners',
          debugShowCheckedModeBanner: false,

          // Configuração de idiomas
          locale: localeProvider.locale,
          localizationsDelegates: const [
            AppLocalizations.delegate,
            GlobalMaterialLocalizations.delegate,
            GlobalWidgetsLocalizations.delegate,
            GlobalCupertinoLocalizations.delegate,
          ],
          supportedLocales: const [Locale('en'), Locale('pt')],

          // Tema da aplicação (definido em AppTheme)
          theme: AppTheme.lightTheme,

          // Rota inicial
          initialRoute: AppRoutes.home,

          // ROTAS NOMEADAS: Permite navegação centralizada e organizada
          // Cada rota mapeia um caminho para um widget de tela
          routes: {
            AppRoutes.home: (context) => const HomeScreen(),
            AppRoutes.credits: (context) => const CreditsScreen(),
            AppRoutes.modules: (context) => const ModulesListScreen(),
          },

          // ROTA GERADORA: Para rotas que precisam receber argumentos
          // Exemplo: passar o ID do módulo para carregar conteúdo específico
          onGenerateRoute: (settings) {
            // Extrai o nome da rota
            final routeName = settings.name;

            // Extrai os argumentos passados (podem ser de qualquer tipo)
            final arguments = settings.arguments;

            // Decide qual tela construir baseado na rota e argumentos
            switch (routeName) {
              case AppRoutes.learningModule:
                // Espera receber o ID do módulo como String
                if (arguments is String) {
                  return MaterialPageRoute(
                    builder: (context) =>
                        LearningModuleScreen(moduleId: arguments),
                  );
                }
                break;

              case AppRoutes.quiz:
                // Espera receber o ID do módulo como String
                if (arguments is String) {
                  return MaterialPageRoute(
                    builder: (context) => QuizScreen(moduleId: arguments),
                  );
                }
                break;

              case AppRoutes.quizResult:
                // Espera receber um Map com moduleId, score e total
                if (arguments is Map<String, dynamic>) {
                  return MaterialPageRoute(
                    builder: (context) => QuizResultScreen(
                      moduleId: arguments['moduleId'] as String,
                      score: arguments['score'] as int,
                      totalQuestions: arguments['total'] as int,
                    ),
                  );
                }
                break;
            }

            // Rota não encontrada - retorna tela de erro
            return MaterialPageRoute(
              builder: (context) => const Scaffold(
                body: Center(child: Text('Página não encontrada')),
              ),
            );
          },
        );
      },
    );
  }
}
