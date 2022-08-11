#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <time.h>

int impar (int n){
	
	int i,vet[n],impar = 0,ehimpar;
	
	srand(time(NULL));

	for(i=0;i<n;i++){
		vet[i]=rand()%100;	
		printf("%d\n",vet[i]);
	}
	

	
	for(i=0;i<n;i++){
		
		ehimpar = vet[i]%2;

		if(ehimpar==1){
			impar++;
		}
		
	}
	
	return impar;
}

int main(){
	
	int nv;
	printf("escreva o numero de variaveis\n");
	scanf("%d",&nv);
	printf("\n");
	
	printf("o numero de impares eh de %d",impar(nv));
	
	return 0;
}
