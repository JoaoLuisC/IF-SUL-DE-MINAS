// Exercício 8 - Imprimir a série de Fibonacci até o 15º termo
void main() {
  final int termos = 15;
  List<int> fib = [1, 1];
  for (int i = 2; i < termos; i++) {
    fib.add(fib[i - 1] + fib[i - 2]);
  }
  print('Série Fibonacci até o $termosº termo:');
  print(fib.take(termos).join(', '));
}
