import 'dart:io';

// Exercício 13 - Receber valores antigo e atual e calcular percentual de acréscimo
void main() {
  stdout.write('Valor antigo: ');
  final antigo = double.tryParse(stdin.readLineSync() ?? '');
  if (antigo == null || antigo == 0) {
    print('Valor antigo inválido.');
    return;
  }

  stdout.write('Valor atual: ');
  final atual = double.tryParse(stdin.readLineSync() ?? '');
  if (atual == null) {
    print('Valor atual inválido.');
    return;
  }

  final diferenca = atual - antigo;
  final percentual = (diferenca / antigo) * 100.0;

  print('Acréscimo: R\$ ${diferenca.toStringAsFixed(2)}');
  print('Percentual de acréscimo: ${percentual.toStringAsFixed(2)}%');
}
