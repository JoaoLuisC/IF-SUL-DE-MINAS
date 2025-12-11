import 'dart:io';

// Exercício 5 - Ler preço de etiqueta e aplicar desconto conforme condição de pagamento
void main() {
  stdout.write('Digite o preço do produto: ');
  final preco = double.tryParse(stdin.readLineSync() ?? '');
  if (preco == null) {
    print('Preço inválido.');
    return;
  }

  print('Condição de pagamento:\n0 - À vista (25%)\n1 - Cheque 30 dias (20%)\n2 - Cartão 2x (10%)\n3 - Cartão 3x (5%)\noutro - negociado (0%)');
  stdout.write('Digite o código da condição de pagamento: ');
  final codigo = int.tryParse(stdin.readLineSync() ?? '');
  if (codigo == null) {
    print('Código inválido.');
    return;
  }

  double descontoPct;
  switch (codigo) {
    case 0:
      descontoPct = 25.0;
      break;
    case 1:
      descontoPct = 20.0;
      break;
    case 2:
      descontoPct = 10.0;
      break;
    case 3:
      descontoPct = 5.0;
      break;
    default:
      descontoPct = 0.0;
  }

  final desconto = preco * descontoPct / 100.0;
  final total = preco - desconto;

  print('Desconto aplicado: ${descontoPct.toStringAsFixed(1)}% -> R\$ ${desconto.toStringAsFixed(2)}');
  print('Preço a pagar: R\$ ${total.toStringAsFixed(2)}');
}
