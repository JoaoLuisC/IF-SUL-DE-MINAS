/// Modelo de dados que representa uma questão de quiz.
///
/// Esta classe define a estrutura de uma pergunta de múltipla escolha,
/// incluindo o enunciado, as opções de resposta e a resposta correta.
class Question {
  /// Enunciado da pergunta (EN)
  final String questionText;

  /// Enunciado da pergunta (PT-BR)
  final String? questionTextPt;

  /// Lista de opções de resposta (EN)
  final List<String> options;

  /// Lista de opções de resposta (PT-BR)
  final List<String>? optionsPt;

  /// Índice (0-based) da resposta correta
  final int correctAnswerIndex;

  const Question({
    required this.questionText,
    this.questionTextPt,
    required this.options,
    this.optionsPt,
    required this.correctAnswerIndex,
  });

  /// Verifica se um índice corresponde à resposta correta
  bool isCorrect(int selectedIndex) {
    return selectedIndex == correctAnswerIndex;
  }

  /// Retorna a resposta correta como string
  String get correctAnswer => options[correctAnswerIndex];

  /// Factory constructor para criar questões a partir de JSON
  factory Question.fromJson(Map<String, dynamic> json) {
    return Question(
      questionText: json['questionText'] as String,
      questionTextPt: json['questionTextPt'] as String?,
      options: List<String>.from(json['options'] as List),
      optionsPt: json['optionsPt'] != null
          ? List<String>.from(json['optionsPt'] as List)
          : null,
      correctAnswerIndex: json['correctAnswerIndex'] as int,
    );
  }

  /// Converte a questão para JSON
  Map<String, dynamic> toJson() {
    return {
      'questionText': questionText,
      'questionTextPt': questionTextPt,
      'options': options,
      'optionsPt': optionsPt,
      'correctAnswerIndex': correctAnswerIndex,
    };
  }
}
