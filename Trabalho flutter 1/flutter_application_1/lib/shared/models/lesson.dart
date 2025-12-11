/// Modelo de dados que representa uma lição educacional.
///
/// Esta classe encapsula as informações principais de uma lição,
/// incluindo título, conteúdo textual e recursos visuais.
/// Usada como estrutura base para organizar o conteúdo dos módulos.
class Lesson {
  /// Título da lição (EN)
  final String title;

  /// Título da lição (PT-BR)
  final String? titlePt;

  /// Conteúdo explicativo em texto (EN)
  final String content;

  /// Conteúdo explicativo em texto (PT-BR)
  final String? contentPt;

  /// Caminho do asset da imagem/ícone relacionado à lição
  final String imagePath;

  const Lesson({
    required this.title,
    this.titlePt,
    required this.content,
    this.contentPt,
    required this.imagePath,
  });

  /// Factory constructor para criar lições a partir de JSON
  factory Lesson.fromJson(Map<String, dynamic> json) {
    return Lesson(
      title: json['title'] as String,
      titlePt: json['titlePt'] as String?,
      content: json['content'] as String,
      contentPt: json['contentPt'] as String?,
      imagePath: json['imagePath'] as String,
    );
  }

  /// Converte a lição para JSON
  Map<String, dynamic> toJson() {
    return {
      'title': title,
      'titlePt': titlePt,
      'content': content,
      'contentPt': contentPt,
      'imagePath': imagePath,
    };
  }
}
