#include <stdio.h>

int soma( int n ){
	
	int i, soma = 0, v;
	
	for (i = 1; i <= n; i++){
		
		printf("escreva um numero para ser somado: \n");	
		scanf("%d", &v);
		soma += v;
		
	}
	
	return soma;
}

int main(){
	
	int num,qtdNum,i,res;
	
	printf("escreva a quantidade de numeros para serem somados: ");
	scanf("%d",&qtdNum);
	
	
	res=soma(qtdNum);
	
	printf("a soma eh: %d",res);
	
	return 0;
}