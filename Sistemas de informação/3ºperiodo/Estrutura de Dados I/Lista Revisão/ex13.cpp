/*
13. Crie uma função que dado um valor, 
retorne a posição que o mesmo se  encontra na fila linear com implementação dinâmica. 
*/


int retorna_posicao_na_fila(FilaDinamica *fila, int elemento) {
    int posicao = 0;
    NoFilaDinamica *no = fila->inicio;
    while (no != NULL) {
        if (no->valor == elemento) {
            return posicao;
        }
        posicao++;
        no = no->proximo;
    }
    return -1;
}

