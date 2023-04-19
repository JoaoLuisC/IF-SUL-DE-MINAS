/*
16. Utilizando uma pilha crie um programa que converta um numero decimal
em  qualquer base de 2 a 8. 
*/

#include <stdio.h>
#define MAX 10

typedef int tdado;
typedef struct{
	tdado pilha[MAX];
	int topo;
}tPilha;
//--------------------
void inicializa(tPilha *p){
	p->topo = -1;
}
//----------------------
int push(tPilha *p, tdado dado){
	if(p->topo == MAX-1) // cheio
		return 0;
	p->topo++;
	p->pilha[p->topo] = dado;	
	return 1;
}
//------------------------
tdado pop(tPilha *p){
	tdado removido = p->pilha[p->topo];
	p->topo--;
	return removido;
}
//---------------------------
tdado peek(tPilha p){
	return p.pilha[p.topo];
}
//------------------------
int isEmpty(tPilha p){
	if (p.topo == -1)
	  return 1; // vazia
	else
	  return 0;  
}
//------------------------
void mostraPilha(tPilha p){
	while(p.topo> -1){
		printf("%d |",p.pilha[p.topo]);
		p.topo--;
	}// fim while
	printf("\n");
}

void converteDecimal(int dec,int base){
	tPilha p;
	inicializa(&p);
	
	while(dec>0){
		 
		push(&p,dec%base);	
		dec = dec/base;
				
	}
	
	mostraPilha(p);
	
}

int main(){
	
	int dec,base;
	printf("Valor para conversao de base:\n");
	scanf("%d",&dec);
	
	printf("Valor da base para converter 2 | 8:\n");
	scanf("%d",&base);
	converteDecimal(dec,base);
	return 0;
	
	
}

