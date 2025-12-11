import 'dart:io';

// Exercício 7 - Aumento de salário por cargo (códigos 101,102,103), senão 40%
void main() {
  stdout.write('Digite o salário atual: ');
  final salario = double.tryParse(stdin.readLineSync() ?? '');
  if (salario == null) {
    print('Salário inválido.');
    return;
  }

  print('Códigos:\n101 - Gerente (10%)\n102 - Engenheiro (20%)\n103 - Técnico (30%)');
  stdout.write('Digite o código do cargo: ');
  final codigo = int.tryParse(stdin.readLineSync() ?? '');
  if (codigo == null) {
    print('Código inválido.');
    return;
  }

  double percentual;
  switch (codigo) {
    case 101:
      percentual = 10.0;
      break;
    case 102:
      percentual = 20.0;
      break;
    case 103:
      percentual = 30.0;
      break;
    default:
      percentual = 40.0;
  }

  final novo = salario * (1 + percentual / 100.0);
  final diferenca = novo - salario;

  print('Salário antigo: R\$ ${salario.toStringAsFixed(2)}');
  print('Percentual aplicado: ${percentual.toStringAsFixed(1)}%');
  print('Novo salário: R\$ ${novo.toStringAsFixed(2)}');
  print('Diferença: R\$ ${diferenca.toStringAsFixed(2)}');
}
