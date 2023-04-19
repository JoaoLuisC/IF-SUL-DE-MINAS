/*
18. Crie a função para mostrar o topo da pilha que utiliza estrutura encadeada. 
*/

int topo_pilha(Pilha *pilha) {
    if (pilha->topo == NULL) {
        printf("Pilha vazia!\n");
        exit(1);
    }
    return pilha->topo->valor;
}
