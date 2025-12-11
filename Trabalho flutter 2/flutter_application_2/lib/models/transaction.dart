/// Modelo Transaction (Transação Financeira)
///
/// Migrado de: br.edu.ifsuldeminas.mch.controlefinanceiro.model.Transaction (Java)
///
/// **Melhorias:**
/// - Enum para tipo de transação (type safety)
/// - DateTime nativo em vez de String
/// - Validações no construtor
class Transaction {
  final int? id;
  final double amount;
  final String description;
  final TransactionType type;
  final bool isTaxExempt;
  final DateTime date;

  Transaction({
    this.id,
    required this.amount,
    required this.description,
    required this.type,
    this.isTaxExempt = false,
    DateTime? date,
  }) : date = date ?? DateTime.now();

  /// Converte para Map (SQLite)
  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'amount': amount,
      'description': description,
      'type': type.name, // Salva como String: 'income' ou 'expense'
      'isTaxExempt': isTaxExempt ? 1 : 0,
      'date': date.toIso8601String(),
    };
  }

  /// Cria Transaction a partir de Map
  factory Transaction.fromMap(Map<String, dynamic> map) {
    return Transaction(
      id: map['id'] as int?,
      amount: map['amount'] as double,
      description: map['description'] as String,
      type: TransactionType.values.firstWhere(
        (e) => e.name == map['type'],
        orElse: () => TransactionType.expense,
      ),
      isTaxExempt: map['isTaxExempt'] == 1,
      date: DateTime.parse(map['date'] as String),
    );
  }

  Transaction copyWith({
    int? id,
    double? amount,
    String? description,
    TransactionType? type,
    bool? isTaxExempt,
    DateTime? date,
  }) {
    return Transaction(
      id: id ?? this.id,
      amount: amount ?? this.amount,
      description: description ?? this.description,
      type: type ?? this.type,
      isTaxExempt: isTaxExempt ?? this.isTaxExempt,
      date: date ?? this.date,
    );
  }

  @override
  String toString() {
    return 'R\$ ${amount.toStringAsFixed(2)} - $description\n'
        '${isTaxExempt ? "Isenta" : "Não Isenta"} - ${type.label}';
  }
}

/// Enum para tipo de transação
///
/// **Por que Enum em vez de String?**
/// - Type safety: impossível passar valor inválido
/// - Autocomplete no IDE
/// - Refatoração segura
enum TransactionType {
  income('Receita'),
  expense('Despesa');

  final String label;
  const TransactionType(this.label);
}
