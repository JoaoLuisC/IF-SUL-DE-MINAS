import 'package:flutter/material.dart';

class AppLocalizations {
  final Locale locale;

  AppLocalizations(this.locale);

  static AppLocalizations of(BuildContext context) {
    return Localizations.of<AppLocalizations>(context, AppLocalizations)!;
  }

  static const LocalizationsDelegate<AppLocalizations> delegate =
      _AppLocalizationsDelegate();

  static final Map<String, Map<String, String>> _localizedValues = {
    'en': {
      // Home Screen
      'app_title': 'English for Beginners',
      'welcome_title': 'Welcome!',
      'welcome_subtitle': 'Learn English in a fun and interactive way',
      'start_learning': 'Start Learning',
      'credits': 'Credits',
      'language': 'Language',

      // Modules
      'modules_title': 'Learning Modules',
      'lessons': 'lessons',
      'flashcards': 'flashcards',
      'questions': 'questions',
      'start_module': 'Start Module',

      // Learning Module
      'lesson': 'Lesson',
      'flashcards_title': 'Flashcards',
      'tap_to_flip': 'Tap to flip',
      'start_quiz': 'Start Quiz',
      'next': 'Next',
      'previous': 'Previous',

      // Quiz
      'quiz_title': 'Quiz',
      'question': 'Question',
      'of_total': 'of',
      'check_answer': 'Check Answer',
      'next_question': 'Next Question',
      'finish_quiz': 'Finish Quiz',
      'correct': 'Correct!',
      'incorrect': 'Incorrect',
      'correct_answer_is': 'The correct answer is',

      // Quiz Results
      'results': 'Results',
      'your_score': 'Your Score',
      'excellent': 'Excellent! You\'re doing great!',
      'very_good': 'Very good! Keep it up!',
      'good_job': 'Good job! Keep practicing!',
      'keep_trying': 'Keep trying! Practice makes perfect!',
      'try_again': 'Try Again',
      'back_to_modules': 'Back to Modules',

      // Credits
      'credits_title': 'Credits',
      'developed_by': 'Developed by',
      'institution': 'IF Sul de Minas',
      'course': 'Course',
      'subject': 'Subject',
      'project': 'Project',
      'about_app': 'About the App',
      'app_description':
          'Educational app designed to teach English vocabulary and essential phrases for beginners, featuring interactive flashcards and quizzes.',
      'technologies': 'Technologies Used',
      'features': 'Main Features',
      'feature_1': 'Interactive 3D Flashcards',
      'feature_2': 'Quizzes with Instant Feedback',
      'feature_3': 'Thematic Learning Modules',
      'feature_4': 'Bilingual Interface (PT/EN)',
      'back': 'Back',
    },
    'pt': {
      // Tela Home
      'app_title': 'Inglês para Iniciantes',
      'welcome_title': 'Bem-vindo!',
      'welcome_subtitle': 'Aprenda inglês de forma divertida e interativa',
      'start_learning': 'Começar a Aprender',
      'credits': 'Créditos',
      'language': 'Idioma',

      // Módulos
      'modules_title': 'Módulos de Aprendizagem',
      'lessons': 'lições',
      'flashcards': 'flashcards',
      'questions': 'questões',
      'start_module': 'Iniciar Módulo',

      // Módulo de Aprendizagem
      'lesson': 'Lição',
      'flashcards_title': 'Flashcards',
      'tap_to_flip': 'Toque para virar',
      'start_quiz': 'Iniciar Quiz',
      'next': 'Próximo',
      'previous': 'Anterior',

      // Quiz
      'quiz_title': 'Quiz',
      'question': 'Questão',
      'of_total': 'de',
      'check_answer': 'Verificar Resposta',
      'next_question': 'Próxima Questão',
      'finish_quiz': 'Finalizar Quiz',
      'correct': 'Correto!',
      'incorrect': 'Incorreto',
      'correct_answer_is': 'A resposta correta é',

      // Resultados do Quiz
      'results': 'Resultados',
      'your_score': 'Sua Pontuação',
      'excellent': 'Excelente! Você está indo muito bem!',
      'very_good': 'Muito bom! Continue assim!',
      'good_job': 'Bom trabalho! Continue praticando!',
      'keep_trying': 'Continue tentando! A prática leva à perfeição!',
      'try_again': 'Tentar Novamente',
      'back_to_modules': 'Voltar aos Módulos',

      // Créditos
      'credits_title': 'Créditos',
      'developed_by': 'Desenvolvido por',
      'institution': 'IF Sul de Minas',
      'course': 'Curso',
      'subject': 'Disciplina',
      'project': 'Projeto',
      'about_app': 'Sobre o Aplicativo',
      'app_description':
          'Aplicativo educacional projetado para ensinar vocabulário e frases essenciais em inglês para iniciantes, com flashcards interativos e quizzes.',
      'technologies': 'Tecnologias Utilizadas',
      'features': 'Funcionalidades Principais',
      'feature_1': 'Flashcards 3D Interativos',
      'feature_2': 'Quizzes com Feedback Instantâneo',
      'feature_3': 'Módulos de Aprendizagem Temáticos',
      'feature_4': 'Interface Bilíngue (PT/EN)',
      'back': 'Voltar',
    },
  };

  String translate(String key) {
    return _localizedValues[locale.languageCode]?[key] ?? key;
  }

  String get appTitle => translate('app_title');
  String get welcomeTitle => translate('welcome_title');
  String get welcomeSubtitle => translate('welcome_subtitle');
  String get startLearning => translate('start_learning');
  String get credits => translate('credits');
  String get language => translate('language');
  String get modulesTitle => translate('modules_title');
  String get lessons => translate('lessons');
  String get flashcards => translate('flashcards');
  String get questions => translate('questions');
  String get startModule => translate('start_module');
  String get lesson => translate('lesson');
  String get flashcardsTitle => translate('flashcards_title');
  String get tapToFlip => translate('tap_to_flip');
  String get startQuiz => translate('start_quiz');
  String get next => translate('next');
  String get previous => translate('previous');
  String get quizTitle => translate('quiz_title');
  String get question => translate('question');
  String get ofTotal => translate('of_total');
  String get checkAnswer => translate('check_answer');
  String get nextQuestion => translate('next_question');
  String get finishQuiz => translate('finish_quiz');
  String get correct => translate('correct');
  String get incorrect => translate('incorrect');
  String get correctAnswerIs => translate('correct_answer_is');
  String get results => translate('results');
  String get yourScore => translate('your_score');
  String get excellent => translate('excellent');
  String get veryGood => translate('very_good');
  String get goodJob => translate('good_job');
  String get keepTrying => translate('keep_trying');
  String get tryAgain => translate('try_again');
  String get backToModules => translate('back_to_modules');
  String get creditsTitle => translate('credits_title');
  String get developedBy => translate('developed_by');
  String get institution => translate('institution');
  String get course => translate('course');
  String get subject => translate('subject');
  String get project => translate('project');
  String get aboutApp => translate('about_app');
  String get appDescription => translate('app_description');
  String get technologies => translate('technologies');
  String get features => translate('features');
  String get feature1 => translate('feature_1');
  String get feature2 => translate('feature_2');
  String get feature3 => translate('feature_3');
  String get feature4 => translate('feature_4');
  String get back => translate('back');
}

class _AppLocalizationsDelegate
    extends LocalizationsDelegate<AppLocalizations> {
  const _AppLocalizationsDelegate();

  @override
  bool isSupported(Locale locale) {
    return ['en', 'pt'].contains(locale.languageCode);
  }

  @override
  Future<AppLocalizations> load(Locale locale) async {
    return AppLocalizations(locale);
  }

  @override
  bool shouldReload(_AppLocalizationsDelegate old) => false;
}
