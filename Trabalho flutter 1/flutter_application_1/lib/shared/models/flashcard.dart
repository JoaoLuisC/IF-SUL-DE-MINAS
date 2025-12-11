/// Modelo de dados que representa um flashcard educacional.
///
/// Esta classe encapsula os dados de um cartão de estudo interativo,
/// contendo uma face frontal (termo/palavra) e uma face traseira (tradução/definição).
/// Projetado para ser usado com o FlashcardWidget animado.
class Flashcard {
  /// Texto exibido na frente do cartão (geralmente em inglês)
  /// Exemplo: "Hello", "Good morning", "One"
  final String frontText;

  /// Texto exibido no verso do cartão (tradução ou explicação)
  /// Exemplo: "Olá", "Bom dia", "Um"
  final String backText;

  /// Categoria opcional para organização (ex: "greetings", "numbers")
  final String? category;

  /// Caminho opcional para uma imagem ilustrativa
  final String? imagePath;

  const Flashcard({
    required this.frontText,
    required this.backText,
    this.category,
    this.imagePath,
  });

  /// Factory constructor para criar flashcards a partir de JSON
  factory Flashcard.fromJson(Map<String, dynamic> json) {
    return Flashcard(
      frontText: json['frontText'] as String,
      backText: json['backText'] as String,
      category: json['category'] as String?,
      imagePath: json['imagePath'] as String?,
    );
  }

  /// Converte o flashcard para JSON
  Map<String, dynamic> toJson() {
    return {
      'frontText': frontText,
      'backText': backText,
      'category': category,
      'imagePath': imagePath,
    };
  }

  /// Método auxiliar para criar flashcards simples rapidamente
  /// Útil durante o desenvolvimento e testes
  factory Flashcard.simple(String front, String back) {
    return Flashcard(frontText: front, backText: back);
  }
}
