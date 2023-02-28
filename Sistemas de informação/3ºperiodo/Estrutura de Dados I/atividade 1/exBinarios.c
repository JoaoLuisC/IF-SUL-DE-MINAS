#include <stdio.h>
#include "bibliotecaPilha.h"


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
