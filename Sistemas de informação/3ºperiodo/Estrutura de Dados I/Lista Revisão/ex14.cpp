/*
14. Crie uma fun��o para apresentar o �ltimo elemento da fila. 
*/

int ultimo_elemento_da_fila(FilaDinamica *fila) {
    if (fila->inicio == NULL) {
        return -1;
    }
    NoFilaDinamica *no = fila->inicio;
    while (no->proximo != NULL) {
        no = no->proximo;
    }
    return no->valor;
}

