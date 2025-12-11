import 'package:dio/dio.dart';
import '../models/currency.dart';

/// CurrencyService - Serviço de Cotações de Moedas
///
/// Migrado de: br.edu.ifsuldeminas.mch.controlefinanceiro.model.CurrencyService (Java)
///
/// **PRINCIPAIS DIFERENÇAS DO JAVA/RETROFIT:**
///
/// 1. **Retrofit vs Dio:**
///    - Java: Retrofit com annotations (@GET, @Query)
///    - Flutter: Dio com métodos diretos (get, post, etc)
///    - Vantagem: Dio é mais simples e não precisa de geração de código
///
/// 2. **Conversão JSON:**
///    - Java: Gson automático com GsonConverterFactory
///    - Flutter: fromJson manual (mais controle e type safety)
///
/// 3. **Tratamento de Erros:**
///    - Java: try/catch com callbacks onSuccess/onFailure
///    - Flutter: try/catch direto com async/await (mais limpo)
class CurrencyService {
  final Dio _dio;
  static const String _baseUrl = 'https://economia.awesomeapi.com.br';

  /// Construtor com Dio injetado (permite testing)
  CurrencyService({Dio? dio})
    : _dio =
          dio ??
          Dio(
            BaseOptions(
              baseUrl: _baseUrl,
              connectTimeout: const Duration(seconds: 10),
              receiveTimeout: const Duration(seconds: 10),
            ),
          );

  /// Lista de moedas suportadas
  static const List<String> supportedCurrencies = [
    'USD-BRL', // Dólar Americano
    'EUR-BRL', // Euro
    'BTC-BRL', // Bitcoin
    'GBP-BRL', // Libra Esterlina
    'CAD-BRL', // Dólar Canadense
    'AUD-BRL', // Dólar Australiano
    'CHF-BRL', // Franco Suíço
    'CNY-BRL', // Yuan Chinês
    'JPY-BRL', // Iene Japonês
    'MXN-BRL', // Peso Mexicano
    'SEK-BRL', // Coroa Sueca
    'NZD-BRL', // Dólar Neozelandês
    'TRY-BRL', // Lira Turca
    'SGD-BRL', // Dólar de Singapura
  ];

  /// Busca cotações de múltiplas moedas
  ///
  /// **Endpoint:**
  /// GET /last/USD-BRL,EUR-BRL,BTC-BRL...
  ///
  /// **Response Format:**
  /// ```json
  /// {
  ///   "USDBRL": {
  ///     "code": "USD",
  ///     "codein": "BRL",
  ///     "name": "Dólar Americano/Real Brasileiro",
  ///     "bid": "5.4321"
  ///   },
  ///   "EURBRL": { ... }
  /// }
  /// ```
  Future<List<Currency>> getExchangeRates({List<String>? currencyList}) async {
    try {
      // Usa lista padrão se nenhuma for especificada
      final selectedCurrencies = currencyList ?? supportedCurrencies;
      final currencyString = selectedCurrencies.join(',');

      // Faz a requisição
      final response = await _dio.get('/last/$currencyString');

      // Valida resposta
      if (response.statusCode != 200) {
        throw CurrencyServiceException(
          'Erro ao buscar cotações: ${response.statusCode}',
        );
      }

      // Converte Map para List<Currency>
      final Map<String, dynamic> data = response.data;
      final List<Currency> currencies = [];

      for (var entry in data.entries) {
        try {
          currencies.add(Currency.fromJson(entry.value));
        } catch (e) {
          print('⚠️ Erro ao parsear moeda ${entry.key}: $e');
          continue; // Ignora moedas com erro
        }
      }

      return currencies;
    } on DioException catch (e) {
      throw CurrencyServiceException(
        'Erro de rede: ${e.message}',
        originalError: e,
      );
    } catch (e) {
      throw CurrencyServiceException('Erro inesperado: $e', originalError: e);
    }
  }

  /// Busca cotação de uma moeda específica
  ///
  /// **Exemplo:**
  /// ```dart
  /// final usd = await service.getSpecificRate('USD', 'BRL');
  /// ```
  Future<Currency?> getSpecificRate(String from, String to) async {
    try {
      final response = await _dio.get('/last/$from-$to');

      if (response.statusCode != 200) {
        throw CurrencyServiceException(
          'Erro ao buscar cotação: ${response.statusCode}',
        );
      }

      final Map<String, dynamic> data = response.data;
      final key = '$from$to';

      if (data.containsKey(key)) {
        return Currency.fromJson(data[key]);
      }

      return null;
    } on DioException catch (e) {
      throw CurrencyServiceException(
        'Erro de rede: ${e.message}',
        originalError: e,
      );
    }
  }
}

/// Exception customizada para erros do serviço de moedas
class CurrencyServiceException implements Exception {
  final String message;
  final Object? originalError;

  CurrencyServiceException(this.message, {this.originalError});

  @override
  String toString() => message;
}
