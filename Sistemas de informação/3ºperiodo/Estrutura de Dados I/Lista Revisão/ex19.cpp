/*
19. Crie uma função isFull que retorne 1 caso uma pilha estática esteja cheia.
*/

int isFull(Pilha *pilha) {
    if (pilha->topo == MAX - 1) {
        return 1;
    } else {
        return 0;
    }
}
