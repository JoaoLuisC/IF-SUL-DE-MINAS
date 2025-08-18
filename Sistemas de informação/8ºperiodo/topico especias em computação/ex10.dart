import 'dart:io';

// Exercício 10 - Verificar se um número inteiro é primo
void main() {
  stdout.write('Digite um número inteiro (>1): ');
  final n = int.tryParse(stdin.readLineSync() ?? '');
  if (n == null || n <= 1) {
    print('Número inválido.');
    return;
  }

  bool primo = true;
  for (int i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      primo = false;
      break;
    }
  }

  if (primo) {
    print('$n é primo.');
  } else {
    print('$n não é primo.');
  }
}
