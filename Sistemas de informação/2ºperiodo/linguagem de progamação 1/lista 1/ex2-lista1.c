#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <time.h>

int maior (int n){
	
	int i,vet[n], maior;
	
	srand(time(NULL));

	for(i=0;i<n;i++){
		vet[i]=rand()%100;	
		printf("%d\n",vet[i]);
	}
	
	maior = vet[0];
	
	for(i=1;i<n;i++){
		
		if(vet[i]>maior){
			maior = vet[i];
		}
		
	}
	
	return maior;
}

int main(){
	
	int nv;
	printf("escreva o numero de variaveis\n");
	scanf("%d",&nv);
	printf("\n");
	
	printf("o maior numero eh %d",maior(nv));
	
	return 0;
}