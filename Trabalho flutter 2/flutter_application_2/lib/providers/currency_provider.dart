import 'package:flutter/foundation.dart';
import '../models/currency.dart';
import '../services/currency_service.dart';

/// CurrencyProvider - Gerenciador de Estado para Cotações
///
/// **Vantagem sobre o Java (CoinsActivity):**
///
/// No Java, fazíamos a requisição diretamente na Activity:
/// - Código acoplado
/// - Difícil de testar
/// - Callback hell
///
/// Aqui usamos Provider:
/// - Desacoplado da UI
/// - Fácil de testar (pode mockar o service)
/// - async/await limpo
class CurrencyProvider with ChangeNotifier {
  final CurrencyService _service;
  List<Currency> _currencies = [];
  bool _isLoading = false;
  String? _error;
  DateTime? _lastUpdate;

  CurrencyProvider({CurrencyService? service})
    : _service = service ?? CurrencyService();

  // Getters
  List<Currency> get currencies => _currencies;
  bool get isLoading => _isLoading;
  String? get error => _error;
  DateTime? get lastUpdate => _lastUpdate;

  /// Indica se os dados são recentes (menos de 5 minutos)
  bool get isDataFresh {
    if (_lastUpdate == null) return false;
    final diff = DateTime.now().difference(_lastUpdate!);
    return diff.inMinutes < 5;
  }

  /// Carrega cotações da API
  ///
  /// **Uso:**
  /// ```dart
  /// await provider.fetchCurrencies();
  /// ```
  Future<void> fetchCurrencies() async {
    _isLoading = true;
    _error = null;
    notifyListeners();

    try {
      _currencies = await _service.getExchangeRates();
      _lastUpdate = DateTime.now();
      _isLoading = false;
      notifyListeners();
    } catch (e) {
      _error = 'Erro ao buscar cotações: $e';
      _isLoading = false;
      notifyListeners();
    }
  }

  /// Recarrega cotações (força nova requisição)
  Future<void> refresh() async {
    await fetchCurrencies();
  }

  /// Busca cotação específica por código
  ///
  /// **Exemplo:**
  /// ```dart
  /// final usd = provider.getCurrencyByCode('USD');
  /// ```
  Currency? getCurrencyByCode(String code) {
    try {
      return _currencies.firstWhere((c) => c.code == code);
    } catch (e) {
      return null;
    }
  }
}
