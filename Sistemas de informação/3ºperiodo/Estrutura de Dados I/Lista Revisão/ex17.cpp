/*
17. Escreva uma função que verifique se uma fila encadeada que contém números 
inteiros está em ordem crescente. 

*/

#include <stdio.h>
#include <stdlib.h>

typedef struct no {
    int valor;
    struct no *prox;
} No;

typedef struct {
    No *inicio;
    No *fim;
    int tamanho;
} Fila;

void inicializa_fila(Fila *fila) {
    fila->inicio = NULL;
    fila->fim = NULL;
    fila->tamanho = 0;
}

void enfileira(Fila *fila, int valor) {
    No *novo_no = (No *)malloc(sizeof(No));
    novo_no->valor = valor;
    novo_no->prox = NULL;
    if (fila->inicio == NULL) {
        fila->inicio = novo_no;
    } else {
        fila->fim->prox = novo_no;
    }
    fila->fim = novo_no;
    fila->tamanho++;
}

int desenfileira(Fila *fila) {
    if (fila->inicio == NULL) {
        printf("Fila vazia!\n");
        exit(1);
    }
    No *no_removido = fila->inicio;
    int valor = no_removido->valor;
    fila->inicio = no_removido->prox;
    if (fila->inicio == NULL) {
        fila->fim = NULL;
    }
    free(no_removido);
    fila->tamanho--;
    return valor;
}

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

int main() {
    Fila fila;
    inicializa_fila(&fila);
    enfileira(&fila, 1);
    enfileira(&fila, 2);
    enfileira(&fila, 3);
    printf("Fila crescente? %d\n", fila_crescente(&fila));  // deve imprimir 1
    enfileira(&fila, 5);
    enfileira(&fila, 4);
    printf("Fila crescente? %d\n", fila_crescente(&fila));  // deve imprimir 0
    return 0;
}

