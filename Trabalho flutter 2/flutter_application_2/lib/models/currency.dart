/// Modelo Currency (Cotação de Moeda)
///
/// Migrado de: br.edu.ifsuldeminas.mch.controlefinanceiro.model.Currency (Java)
///
/// **Mudanças:**
/// - No Java usávamos Retrofit com annotations
/// - Em Flutter/Dart usamos Dio com métodos fromJson explícitos
/// - Melhor tratamento de tipos (double em vez de String para valores)
class Currency {
  final String code; // Ex: USD
  final String codein; // Ex: BRL
  final String name; // Ex: Dólar Americano/Real Brasileiro
  final double bid; // Valor de compra
  final double ask; // Valor de venda (opcional)
  final double high; // Máxima do dia
  final double low; // Mínima do dia

  Currency({
    required this.code,
    required this.codein,
    required this.name,
    required this.bid,
    this.ask = 0.0,
    this.high = 0.0,
    this.low = 0.0,
  });

  /// Cria Currency a partir do JSON da API
  ///
  /// **API Response Format:**
  /// ```json
  /// {
  ///   "USDBRL": {
  ///     "code": "USD",
  ///     "codein": "BRL",
  ///     "name": "Dólar Americano/Real Brasileiro",
  ///     "bid": "5.4321"
  ///   }
  /// }
  /// ```
  factory Currency.fromJson(Map<String, dynamic> json) {
    return Currency(
      code: json['code'] as String? ?? '',
      codein: json['codein'] as String? ?? '',
      name: json['name'] as String? ?? '',
      bid: _parseDouble(json['bid']),
      ask: _parseDouble(json['ask']),
      high: _parseDouble(json['high']),
      low: _parseDouble(json['low']),
    );
  }

  /// Helper para converter String para double com segurança
  static double _parseDouble(dynamic value) {
    if (value == null) return 0.0;
    if (value is double) return value;
    if (value is int) return value.toDouble();
    if (value is String) {
      return double.tryParse(value) ?? 0.0;
    }
    return 0.0;
  }

  /// Formata para exibição na lista
  ///
  /// **Exemplo de saída:**
  /// "1 USD (Dólar Americano) | 5.43 BRL (Real Brasileiro)"
  String getDisplayText() {
    // Separa o nome antes e depois da barra
    final parts = name.split('/');
    final firstCoin = parts.isNotEmpty ? parts[0].trim() : '';
    final otherCoin = parts.length > 1 ? parts[1].trim() : '';

    return '1 $code ($firstCoin) | ${bid.toStringAsFixed(2)} $codein ($otherCoin)';
  }

  @override
  String toString() => getDisplayText();
}
