/*
13. Crie uma fun��o que dado um valor, 
retorne a posi��o que o mesmo se  encontra na fila linear com implementa��o din�mica. 
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

