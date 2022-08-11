#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int somav (int n){
	
	int i,vet[n], soma = 0;
	
	srand(time(NULL));

	for(i=0;i<n;i++){
		vet[i]=rand()%10;
		soma+=vet[i];
	}
	
	return soma;
}
int main(){
	
	int nv,somat;
	
	printf("Entre com o numero de vetores entre 0 ate 100\n");
	scanf("%d",&nv);
	printf("\n");
	
	somat = somav(nv);
	
	printf("a soma entre os valores do vetor eh de %d\n",somat);
	
	return 0;
}