import 'package:flutter/foundation.dart';
import '../models/bill.dart';
import '../services/local_storage_service.dart';

/// BillProvider - Gerenciador de Estado para Contas usando LocalStorageService
class BillProvider with ChangeNotifier {
  final LocalStorageService _storage;
  List<Bill> _bills = [];
  bool _isLoading = false;
  String? _error;

  BillProvider({LocalStorageService? localStorage})
    : _storage = localStorage ?? LocalStorageService();

  List<Bill> get bills => _bills;
  bool get isLoading => _isLoading;
  String? get error => _error;
  double get totalBills => _bills.fold(0.0, (sum, bill) => sum + bill.value);
  int get billCount => _bills.length;

  Future<void> loadBills() async {
    _isLoading = true;
    _error = null;
    notifyListeners();

    try {
      _bills = await _storage.getAllBills();
      _isLoading = false;
      notifyListeners();
    } catch (e) {
      _error = 'Erro ao carregar contas: $e';
      _isLoading = false;
      notifyListeners();
    }
  }

  Future<bool> addBill(Bill bill) async {
    try {
      await _storage.insertBill(bill);
      await loadBills();
      return true;
    } catch (e) {
      _error = 'Erro ao adicionar conta: $e';
      notifyListeners();
      return false;
    }
  }

  Future<bool> updateBill(Bill bill) async {
    try {
      await _storage.updateBill(bill);
      await loadBills();
      return true;
    } catch (e) {
      _error = 'Erro ao atualizar conta: $e';
      notifyListeners();
      return false;
    }
  }

  Future<bool> deleteBill(int id) async {
    try {
      await _storage.deleteBill(id);
      await loadBills();
      return true;
    } catch (e) {
      _error = 'Erro ao deletar conta: $e';
      notifyListeners();
      return false;
    }
  }

  Future<Bill?> getBillById(int id) async {
    try {
      return await _storage.getBillById(id);
    } catch (e) {
      _error = 'Erro ao buscar conta: $e';
      notifyListeners();
      return null;
    }
  }

  void clearError() {
    _error = null;
    notifyListeners();
  }
}
