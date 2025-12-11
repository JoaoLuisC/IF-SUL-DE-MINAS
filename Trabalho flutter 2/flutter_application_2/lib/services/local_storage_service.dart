import 'dart:convert';
import 'package:shared_preferences/shared_preferences.dart';
import '../models/bill.dart';
import '../models/transaction.dart' as app_transaction;

/// LocalStorageService - Banco de dados local usando SharedPreferences
///
/// **SOLUÇÃO MULTIPLATAFORMA:**
/// - Funciona em: Android, iOS, Web, Windows, macOS, Linux
/// - Sem dependências nativas problemáticas
/// - Dados armazenados em JSON
class LocalStorageService {
  static final LocalStorageService _instance = LocalStorageService._internal();
  static SharedPreferences? _prefs;

  // Chaves de armazenamento
  static const String _billsKey = 'bills_data';
  static const String _transactionsKey = 'transactions_data';
  static const String _billIdCounterKey = 'bill_id_counter';
  static const String _transactionIdCounterKey = 'transaction_id_counter';

  factory LocalStorageService() {
    return _instance;
  }

  LocalStorageService._internal();

  /// Inicializa o SharedPreferences
  Future<void> init() async {
    _prefs ??= await SharedPreferences.getInstance();
  }

  SharedPreferences get prefs {
    if (_prefs == null) {
      throw Exception('LocalStorageService não inicializado. Chame init() primeiro.');
    }
    return _prefs!;
  }

  // ==================== BILLS (CONTAS) ====================

  /// Busca todas as contas
  Future<List<Bill>> getAllBills() async {
    await init();
    final String? billsJson = prefs.getString(_billsKey);
    
    if (billsJson == null || billsJson.isEmpty) {
      return [];
    }

    try {
      final List<dynamic> decoded = jsonDecode(billsJson);
      return decoded.map((json) => Bill.fromMap(json)).toList();
    } catch (e) {
      print('❌ Erro ao carregar contas: $e');
      return [];
    }
  }

  /// Busca uma conta por ID
  Future<Bill?> getBillById(int id) async {
    final bills = await getAllBills();
    try {
      return bills.firstWhere((bill) => bill.id == id);
    } catch (e) {
      return null;
    }
  }

  /// Insere uma nova conta
  Future<int> insertBill(Bill bill) async {
    await init();
    
    // Gera novo ID
    int newId = prefs.getInt(_billIdCounterKey) ?? 1;
    final newBill = Bill(
      id: newId,
      name: bill.name,
      description: bill.description,
      value: bill.value,
      date: bill.date,
    );

    // Carrega contas existentes
    final bills = await getAllBills();
    bills.add(newBill);

    // Salva
    await _saveBills(bills);
    await prefs.setInt(_billIdCounterKey, newId + 1);

    return newId;
  }

  /// Atualiza uma conta existente
  Future<int> updateBill(Bill bill) async {
    await init();
    
    final bills = await getAllBills();
    final index = bills.indexWhere((b) => b.id == bill.id);

    if (index == -1) {
      return 0; // Não encontrado
    }

    bills[index] = bill;
    await _saveBills(bills);
    return 1;
  }

  /// Deleta uma conta
  Future<int> deleteBill(int id) async {
    await init();
    
    final bills = await getAllBills();
    final originalLength = bills.length;
    bills.removeWhere((bill) => bill.id == id);

    if (bills.length == originalLength) {
      return 0; // Não encontrado
    }

    await _saveBills(bills);
    return 1;
  }

  /// Salva lista de contas no SharedPreferences
  Future<void> _saveBills(List<Bill> bills) async {
    final jsonString = jsonEncode(bills.map((b) => b.toMap()).toList());
    await prefs.setString(_billsKey, jsonString);
  }

  // ==================== TRANSACTIONS (TRANSAÇÕES) ====================

  /// Busca todas as transações
  Future<List<app_transaction.Transaction>> getAllTransactions() async {
    await init();
    final String? transactionsJson = prefs.getString(_transactionsKey);
    
    if (transactionsJson == null || transactionsJson.isEmpty) {
      return [];
    }

    try {
      final List<dynamic> decoded = jsonDecode(transactionsJson);
      return decoded.map((json) => app_transaction.Transaction.fromMap(json)).toList();
    } catch (e) {
      print('❌ Erro ao carregar transações: $e');
      return [];
    }
  }

  /// Busca uma transação por ID
  Future<app_transaction.Transaction?> getTransactionById(int id) async {
    final transactions = await getAllTransactions();
    try {
      return transactions.firstWhere((t) => t.id == id);
    } catch (e) {
      return null;
    }
  }

  /// Insere uma nova transação
  Future<int> insertTransaction(app_transaction.Transaction transaction) async {
    await init();
    
    // Gera novo ID
    int newId = prefs.getInt(_transactionIdCounterKey) ?? 1;
    final newTransaction = app_transaction.Transaction(
      id: newId,
      description: transaction.description,
      amount: transaction.amount,
      type: transaction.type,
      isTaxExempt: transaction.isTaxExempt,
      date: transaction.date,
    );

    // Carrega transações existentes
    final transactions = await getAllTransactions();
    transactions.add(newTransaction);

    // Salva
    await _saveTransactions(transactions);
    await prefs.setInt(_transactionIdCounterKey, newId + 1);

    return newId;
  }

  /// Atualiza uma transação existente
  Future<int> updateTransaction(app_transaction.Transaction transaction) async {
    await init();
    
    final transactions = await getAllTransactions();
    final index = transactions.indexWhere((t) => t.id == transaction.id);

    if (index == -1) {
      return 0; // Não encontrado
    }

    transactions[index] = transaction;
    await _saveTransactions(transactions);
    return 1;
  }

  /// Deleta uma transação
  Future<int> deleteTransaction(int id) async {
    await init();
    
    final transactions = await getAllTransactions();
    final originalLength = transactions.length;
    transactions.removeWhere((t) => t.id == id);

    if (transactions.length == originalLength) {
      return 0; // Não encontrado
    }

    await _saveTransactions(transactions);
    return 1;
  }

  /// Salva lista de transações no SharedPreferences
  Future<void> _saveTransactions(List<app_transaction.Transaction> transactions) async {
    final jsonString = jsonEncode(transactions.map((t) => t.toMap()).toList());
    await prefs.setString(_transactionsKey, jsonString);
  }

  // ==================== UTILIDADES ====================

  /// Limpa todo o banco de dados
  Future<void> clearAll() async {
    await init();
    await prefs.remove(_billsKey);
    await prefs.remove(_transactionsKey);
    await prefs.remove(_billIdCounterKey);
    await prefs.remove(_transactionIdCounterKey);
  }

  /// Reseta os contadores de ID
  Future<void> resetCounters() async {
    await init();
    await prefs.setInt(_billIdCounterKey, 1);
    await prefs.setInt(_transactionIdCounterKey, 1);
  }
}
