import 'dart:io';

// Exercício 1 - Leia um inteiro e o imprima; depois leia um número real e também o imprima.
void main() {
  stdout.write('Digite um número inteiro: ');
  final int? inteiro = int.tryParse(stdin.readLineSync() ?? '');
  if (inteiro == null) {
    print('Entrada inválida para inteiro.');
  } else {
    print('Você digitou o inteiro: $inteiro');
  }

  stdout.write('Digite um número real (use . ou ,): ');
  final inputReal = stdin.readLineSync() ?? '';
  final double? real = double.tryParse(inputReal.replaceAll(',', '.'));
  if (real == null) {
    print('Entrada inválida para real.');
  } else {
    print('Você digitou o real: $real');
  }
}
