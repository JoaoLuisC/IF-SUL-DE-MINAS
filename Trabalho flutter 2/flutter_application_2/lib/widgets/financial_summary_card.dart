import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../providers/bill_provider.dart';
import '../providers/transaction_provider.dart';

/// Widget de Resumo Financeiro no Dashboard
class FinancialSummaryCard extends StatelessWidget {
  const FinancialSummaryCard({super.key});

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 4,
      child: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text(
              'Resumo Financeiro',
              style: Theme.of(
                context,
              ).textTheme.titleLarge?.copyWith(fontWeight: FontWeight.bold),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 20),
            Consumer2<BillProvider, TransactionProvider>(
              builder: (context, billProvider, transactionProvider, child) {
                final totalBills = billProvider.totalBills;
                final balance = transactionProvider.balance;
                final totalIncome = transactionProvider.totalIncome;
                final totalExpense = transactionProvider.totalExpense;

                return Column(
                  children: [
                    _SummaryRow(
                      label: 'Contas a Pagar',
                      value: totalBills,
                      color: Colors.red,
                      icon: Icons.credit_card,
                    ),
                    const Divider(height: 24),
                    _SummaryRow(
                      label: 'Total Receitas',
                      value: totalIncome,
                      color: Colors.green,
                      icon: Icons.arrow_upward,
                    ),
                    const Divider(height: 24),
                    _SummaryRow(
                      label: 'Total Despesas',
                      value: totalExpense,
                      color: Colors.orange,
                      icon: Icons.arrow_downward,
                    ),
                    const Divider(height: 24),
                    _SummaryRow(
                      label: 'Saldo',
                      value: balance,
                      color: balance >= 0 ? Colors.blue : Colors.red,
                      icon: Icons.account_balance_wallet,
                      isHighlight: true,
                    ),
                  ],
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}

class _SummaryRow extends StatelessWidget {
  final String label;
  final double value;
  final Color color;
  final IconData icon;
  final bool isHighlight;

  const _SummaryRow({
    required this.label,
    required this.value,
    required this.color,
    required this.icon,
    this.isHighlight = false,
  });

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Icon(icon, color: color, size: 24),
        const SizedBox(width: 12),
        Expanded(
          child: Text(
            label,
            style: TextStyle(
              fontSize: isHighlight ? 18 : 16,
              fontWeight: isHighlight ? FontWeight.bold : FontWeight.normal,
            ),
          ),
        ),
        Text(
          'R\$ ${value.toStringAsFixed(2)}',
          style: TextStyle(
            fontSize: isHighlight ? 20 : 18,
            fontWeight: FontWeight.bold,
            color: color,
          ),
        ),
      ],
    );
  }
}
