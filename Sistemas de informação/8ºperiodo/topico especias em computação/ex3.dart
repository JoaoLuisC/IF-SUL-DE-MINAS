import 'dart:io';

// Exercício 3 - Leia o salário de um funcionário e imprima com aumento de 15%.
void main() {
  stdout.write('Digite o salário atual: ');
  final input = stdin.readLineSync() ?? '';
  final double? salario = double.tryParse(input.replaceAll(',', '.'));
  if (salario == null) {
    print('Entrada inválida.');
    return;
  }
  final novoSalario = salario * 1.15;
  print('Salário com 15% de aumento: R\$ ${novoSalario.toStringAsFixed(2)}');
}
