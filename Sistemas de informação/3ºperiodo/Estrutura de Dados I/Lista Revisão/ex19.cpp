/*
19. Crie uma fun��o isFull que retorne 1 caso uma pilha est�tica esteja cheia.
*/

int isFull(Pilha *pilha) {
    if (pilha->topo == MAX - 1) {
        return 1;
    } else {
        return 0;
    }
}
