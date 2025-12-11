/// Modelo Bill (Conta a Pagar)
///
/// Migrado de: br.edu.ifsuldeminas.mch.controlefinanceiro.model.Bill (Java)
///
/// **Diferenças do Java:**
/// - No Java, usávamos getters/setters manuais
/// - Em Dart, usamos construtores nomeados e propriedades finais (imutabilidade)
/// - Melhor integração com JSON através de métodos toMap/fromMap
class Bill {
  final int? id;
  final String name;
  final String description;
  final double value;
  final String date; // Formato: dd/MM/yyyy

  Bill({
    this.id,
    required this.name,
    required this.description,
    required this.value,
    required this.date,
  });

  /// Converte Bill para Map (usado pelo SQLite)
  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'name': name,
      'description': description,
      'value': value,
      'date': date,
    };
  }

  /// Cria Bill a partir de Map (vindo do SQLite)
  factory Bill.fromMap(Map<String, dynamic> map) {
    return Bill(
      id: map['id'] as int?,
      name: map['name'] as String,
      description: map['description'] as String,
      value: map['value'] as double,
      date: map['date'] as String,
    );
  }

  /// Cria cópia com modificações (útil para edições)
  Bill copyWith({
    int? id,
    String? name,
    String? description,
    double? value,
    String? date,
  }) {
    return Bill(
      id: id ?? this.id,
      name: name ?? this.name,
      description: description ?? this.description,
      value: value ?? this.value,
      date: date ?? this.date,
    );
  }

  @override
  String toString() {
    return 'R\$ ${value.toStringAsFixed(2)} - $name - $date';
  }
}
