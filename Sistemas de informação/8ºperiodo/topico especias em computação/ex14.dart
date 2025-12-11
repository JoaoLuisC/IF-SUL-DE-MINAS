import 'dart:io';

// Exercício 14 - Verificar ano bissexto (divisível por 400 ou por 4 e não por 100)
void main() {
  stdout.write('Digite o ano: ');
  final ano = int.tryParse(stdin.readLineSync() ?? '');
  if (ano == null) {
    print('Ano inválido.');
    return;
  }

  final bool bissexto = (ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0);
  if (bissexto) {
    print('$ano é bissexto.');
  } else {
    print('$ano não é bissexto.');
  }
}
