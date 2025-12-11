import 'lesson.dart';
import 'question.dart';
import 'flashcard.dart';

enum ModuleLevel { basic, intermediate, advanced }

/// Modelo que representa um módulo completo de aprendizagem.
///
/// Um módulo agrupa lições, flashcards e questões sobre um tema específico.
/// Exemplo: "Basic Greetings", "Numbers 1-10", "Colors"
class LearningModule {
  /// Identificador único do módulo (ex: "greetings", "numbers")
  final String id;

  /// Título do módulo exibido ao usuário (EN)
  final String title;

  /// Título do módulo em português
  final String? titlePt;

  /// Descrição breve do que será aprendido (EN)
  final String description;

  /// Descrição em português
  final String? descriptionPt;

  /// Emoji representativo do módulo
  final String iconEmoji;

  /// Nível de dificuldade
  final ModuleLevel level;

  /// Lista de lições teóricas do módulo
  final List<Lesson> lessons;

  /// Lista de flashcards para prática
  final List<Flashcard> flashcards;

  /// Lista de questões para avaliação final
  final List<Question> quizQuestions;

  /// Cor temática do módulo (em hexadecimal)
  final int color;

  const LearningModule({
    required this.id,
    required this.title,
    this.titlePt,
    required this.description,
    this.descriptionPt,
    required this.iconEmoji,
    required this.level,
    required this.lessons,
    required this.flashcards,
    required this.quizQuestions,
    required this.color,
  });

  /// Retorna a quantidade total de conteúdo no módulo
  int get totalContentItems => lessons.length + flashcards.length;

  /// Verifica se o módulo tem conteúdo mínimo necessário
  bool get isValid {
    return lessons.isNotEmpty &&
        flashcards.isNotEmpty &&
        quizQuestions.length >= 3;
  }
}
