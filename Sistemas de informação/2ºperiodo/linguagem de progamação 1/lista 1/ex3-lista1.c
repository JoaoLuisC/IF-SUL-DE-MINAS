#include <stdio.h>
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <time.h>

int menor (int n){
	
	int i,vet[n], menor;
	
	srand(time(NULL));

	for(i=0;i<n;i++){
		vet[i]=rand()%100;	
		printf("%d\n",vet[i]);
	}
	
	menor = vet[0];
	
	for(i=1;i<n;i++){
		
		if(vet[i]<menor){
			menor = vet[i];
		}
		
	}
	
	return menor;
}

int main(){
	
	int nv;
	printf("escreva o numero de variaveis\n");
	scanf("%d",&nv);
	printf("\n");
	
	printf("o menor numero eh %d",menor(nv));
	
	return 0;
}