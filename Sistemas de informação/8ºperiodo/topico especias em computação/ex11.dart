// Exercício 11 - Armazenar 5 números e imprimir em ordem inversa
void main() {
  List<int> nums = [10, 20, 30, 40, 50]; // exemplo, sem entrada do usuário
  print('Lista original: ${nums.join(', ')}');
  print('Ordem inversa: ${nums.reversed.join(', ')}');
}
