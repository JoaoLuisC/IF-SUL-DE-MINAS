import 'dart:io';

// Exercício 2 - Leia um número real e imprima a quinta parte dele.
void main() {
  stdout.write('Digite um número real: ');
  final input = stdin.readLineSync() ?? '';
  final double? numReal = double.tryParse(input.replaceAll(',', '.'));
  if (numReal == null) {
    print('Entrada inválida.');
    return;
  }
  final quinta = numReal / 5;
  print('A quinta parte de $numReal é $quinta');
}
