import 'dart:io';

// Exercício 6 - DETRAN: taxa 1% para carro antes de 2000, 1.5% para 2000 em diante
void main() {
  stdout.write('Digite o ano do veículo: ');
  final ano = int.tryParse(stdin.readLineSync() ?? '');
  if (ano == null) {
    print('Ano inválido.');
    return;
  }

  stdout.write('Digite o preço do carro: ');
  final preco = double.tryParse(stdin.readLineSync() ?? '');
  if (preco == null) {
    print('Preço inválido.');
    return;
  }

  final taxa = (ano < 2000) ? 0.01 : 0.015;
  final imposto = preco * taxa;

  print('Ano: $ano');
  print('Preço: R\$ ${preco.toStringAsFixed(2)}');
  print('Taxa aplicada: ${(taxa * 100).toStringAsFixed(2)}%');
  print('Imposto a pagar: R\$ ${imposto.toStringAsFixed(2)}');
}
