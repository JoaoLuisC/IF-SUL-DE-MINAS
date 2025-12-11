import 'package:flutter/foundation.dart';
import '../models/transaction.dart';
import '../services/local_storage_service.dart';

/// TransactionProvider - Gerenciador de Estado para Transações usando LocalStorageService
class TransactionProvider with ChangeNotifier {
  final LocalStorageService _storage;
  List<Transaction> _transactions = [];
  bool _isLoading = false;
  String? _error;

  TransactionProvider({LocalStorageService? localStorage})
    : _storage = localStorage ?? LocalStorageService();

  List<Transaction> get transactions => _transactions;
  bool get isLoading => _isLoading;
  String? get error => _error;
  
  double get totalIncome => _transactions
      .where((t) => t.type == TransactionType.income)
      .fold<double>(0.0, (sum, t) => sum + t.amount);
  
  double get totalExpense => _transactions
      .where((t) => t.type == TransactionType.expense)
      .fold<double>(0.0, (sum, t) => sum + t.amount);
  
  double get balance => totalIncome - totalExpense;
  int get transactionCount => _transactions.length;

  Future<void> loadTransactions() async {
    _isLoading = true;
    _error = null;
    notifyListeners();

    try {
      _transactions = await _storage.getAllTransactions();
      _isLoading = false;
      notifyListeners();
    } catch (e) {
      _error = 'Erro ao carregar transações: $e';
      _isLoading = false;
      notifyListeners();
    }
  }

  Future<bool> addTransaction(Transaction transaction) async {
    try {
      await _storage.insertTransaction(transaction);
      await loadTransactions();
      return true;
    } catch (e) {
      _error = 'Erro ao adicionar transação: $e';
      notifyListeners();
      return false;
    }
  }

  Future<bool> updateTransaction(Transaction transaction) async {
    try {
      await _storage.updateTransaction(transaction);
      await loadTransactions();
      return true;
    } catch (e) {
      _error = 'Erro ao atualizar transação: $e';
      notifyListeners();
      return false;
    }
  }

  Future<bool> deleteTransaction(int id) async {
    try {
      await _storage.deleteTransaction(id);
      await loadTransactions();
      return true;
    } catch (e) {
      _error = 'Erro ao deletar transação: $e';
      notifyListeners();
      return false;
    }
  }

  Future<Transaction?> getTransactionById(int id) async {
    try {
      return await _storage.getTransactionById(id);
    } catch (e) {
      _error = 'Erro ao buscar transação: $e';
      notifyListeners();
      return null;
    }
  }

  void clearError() {
    _error = null;
    notifyListeners();
  }
}
