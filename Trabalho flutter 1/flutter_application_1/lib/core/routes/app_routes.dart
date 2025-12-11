/// Classe que centraliza todas as rotas nomeadas da aplicação.
///
/// ARQUITETURA: Usar rotas nomeadas facilita a navegação e permite
/// mudanças futuras sem afetar múltiplos arquivos.
///
/// PADRÃO: Todas as rotas começam com '/' e usam kebab-case.
class AppRoutes {
  // Rota inicial da aplicação
  static const String home = '/';

  // Rota para a tela de créditos
  static const String credits = '/credits';

  // Rota para listagem de módulos disponíveis
  static const String modules = '/modules';

  // Rota para o conteúdo de um módulo específico
  // Uso: Navigator.pushNamed(context, AppRoutes.learningModule, arguments: moduleId)
  static const String learningModule = '/learning-module';

  // Rota para a tela de quiz
  // Uso: Navigator.pushNamed(context, AppRoutes.quiz, arguments: moduleId)
  static const String quiz = '/quiz';

  // Rota para resultado do quiz
  static const String quizResult = '/quiz-result';

  // Lista de todas as rotas (útil para validação)
  static const List<String> allRoutes = [
    home,
    credits,
    modules,
    learningModule,
    quiz,
    quizResult,
  ];
}
