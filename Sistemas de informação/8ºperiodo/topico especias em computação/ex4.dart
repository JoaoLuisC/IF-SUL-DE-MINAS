import 'dart:io';

// Exercício 4 - Lanchonete XYZ: escolher salgados e bebidas (um tipo cada), calcular total e aplicar
// desconto de 10% se ultrapassar R\$100.00.

void main() {
  final salgados = {
    1: {'nome': 'Coxinha', 'preco': 5.0},
    2: {'nome': 'Rissole', 'preco': 4.5},
    3: {'nome': 'Kibe', 'preco': 6.0},
  };

  final bebidas = {
    1: {'nome': 'Refrigerante Lata', 'preco': 6.0},
    2: {'nome': 'Suco Natural', 'preco': 7.5},
    3: {'nome': 'Água 500ml', 'preco': 3.0},
  };

  print('--- Cardápio Salgados ---');
  salgados.forEach((k, v) => print('$k - ${v['nome']} : R\$${v['preco']}'));

  stdout.write('Escolha o código do salgado: ');
  final codSalgado = int.tryParse(stdin.readLineSync() ?? '');
  if (codSalgado == null || !salgados.containsKey(codSalgado)) {
    print('Código de salgado inválido.');
    return;
  }

  stdout.write('Quantidade de salgados: ');
  final qtdSalgado = int.tryParse(stdin.readLineSync() ?? '');
  if (qtdSalgado == null || qtdSalgado <= 0) {
    print('Quantidade inválida.');
    return;
  }

  print('\n--- Cardápio Bebidas ---');
  bebidas.forEach((k, v) => print('$k - ${v['nome']} : R\$${v['preco']}'));

  stdout.write('Escolha o código da bebida: ');
  final codBebida = int.tryParse(stdin.readLineSync() ?? '');
  if (codBebida == null || !bebidas.containsKey(codBebida)) {
    print('Código de bebida inválido.');
    return;
  }

  stdout.write('Quantidade de bebidas: ');
  final qtdBebida = int.tryParse(stdin.readLineSync() ?? '');
  if (qtdBebida == null || qtdBebida <= 0) {
    print('Quantidade inválida.');
    return;
  }

  final precoSalgado = salgados[codSalgado]!['preco'] as double;
  final precoBebida = bebidas[codBebida]!['preco'] as double;

  double total = precoSalgado * qtdSalgado + precoBebida * qtdBebida;

  print('\nValor parcial: R\$ ${total.toStringAsFixed(2)}');

  if (total > 100.0) {
    final desconto = total * 0.10;
    total -= desconto;
    print('Pedido acima de R\$100.00. Aplicado desconto de 10%: -R\$ ${desconto.toStringAsFixed(2)}');
  }

  print('Valor total a pagar: R\$ ${total.toStringAsFixed(2)}');
}
