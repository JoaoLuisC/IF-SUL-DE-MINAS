import 'dart:io';

// Exercício 9 - Fatorial de um número inteiro
void main() {
  stdout.write('Digite um inteiro não negativo: ');
  final n = int.tryParse(stdin.readLineSync() ?? '');
  if (n == null || n < 0) {
    print('Entrada inválida.');
    return;
  }

  BigInt fat = BigInt.one;
  for (int i = 1; i <= n; i++) {
    fat *= BigInt.from(i);
  }

  print('Fatorial de $n é $fat');
}
