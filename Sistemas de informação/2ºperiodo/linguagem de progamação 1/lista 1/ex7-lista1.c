#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void mV (int n){

	int i,vet1[n],vet2[n],vet3[n];
	
	srand(time(NULL));
	
	for(i=0;i<n;i++){		
		vet1[i]=rand()%100;
		vet2[i]=rand()%100;
		printf("vetor 1: %d     vetor 2: %d\n",vet1[i],vet2[i]);
	}
	
	printf("\n");
	
	for(i=0;i<n;i++){		
		vet3[i]=vet1[i]*vet2[i]; 
		printf("o produdo dos vetores %d e %d eh igual a %d.\n",vet1[i],vet2[i],vet3[i]);
	}
}
int main(){
	
	int vet,escolha;
	
	printf("Escolha 1: para escolher o tamanho dos vetores.\n");
	printf("Escolha 2: para aleatorizar o tamanho dos vetores.\n");
	scanf("%d",&escolha);
	
	if(escolha==1){
		printf("escolha o tamanho dos vetores:\n");
		scanf("%d",&vet);
		mV(vet);
	}else {
		srand(time(NULL));
		vet=rand()%20+1;
		mV(vet);
	}
	
	return 0;
}
