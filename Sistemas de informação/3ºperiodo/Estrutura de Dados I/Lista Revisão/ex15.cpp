/*
15. Crie uma função para mostrar a quantidade de elementos da fila.1
*/
int quantidade_elementos_da_fila(FilaDinamica *fila) {
    int quantidade = 0;
    NoFilaDinamica *no = fila->inicio;
    while (no != NULL) {
        quantidade++;
        no = no->proximo;
    }
    return quantidade;
}

