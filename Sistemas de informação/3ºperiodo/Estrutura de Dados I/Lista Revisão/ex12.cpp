/*
12. Crie uma função para verificar se um elemento existe em uma fila circular estática. 
*/

int verifica_elemento_na_fila(int fila[], int tamanho, int elemento) {
	
    int i, inicio = 0, fim = tamanho - 1;
    
    while (inicio <= fim) {
        int meio = (inicio + fim) / 2;
        if (fila[meio] == elemento) {
            return 1;
        } else if (fila[meio] > elemento) {
            fim = meio - 1;
        } else {
            inicio = meio + 1;
        }
    }
    return 0;
}

