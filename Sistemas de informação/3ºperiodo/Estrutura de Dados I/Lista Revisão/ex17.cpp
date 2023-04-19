/*
17. Escreva uma função que verifique se uma fila encadeada que contém números 
inteiros está em ordem crescente. 

*/

int fila_crescente(Fila *fila) {
    if (fila->tamanho <= 1) {
        return 1;  // fila vazia ou com apenas um elemento é sempre crescente
    }
    int valor_anterior = desenfileira(fila);
    while (fila->inicio != NULL) {
        int valor_atual = desenfileira(fila);
        if (valor_atual < valor_anterior) {
            return 0;  // fila não está em ordem crescente
        }
        valor_anterior = valor_atual;
    }
    return 1;  // fila está em ordem crescente
}


