#include <stdio.h>
#include <stdlib.h>
float maior (int n,float *vetor){
	
	int i;	float maior;
	
	maior = vetor[0];

	for(i=0;i<n;i++){
		if(vetor[i]>maior){
			maior = vetor[i];
		}
		
	}
	
	return maior;
}

float menor (int n,float *vetor){
	
	int i;	float menor;
	
	menor = vetor[0];
	
	for(i=1;i<n;i++){
		
		if(vetor[i]<menor){
			menor = vetor[i];
		}
		
	}
	
	return menor;
}

float somar (int n,float *vetor){
	
	int i;
	float soma=0;
	
	for(i=0;i<n;i++){
		
		soma+=vetor[i];
		
	}
	
	return soma;
	
}

int main(){
	
	float vet[5],j,d,res;
	int i;
	
	for(i=0;i<5;i++){
		scanf("%f",&vet[i]);
	}

	j = maior(5,vet);
	d = menor(5,vet);
	
	res = somar(5,vet);
	
	
	printf("%.1f",res-(j+d));
	
	
	
	return 0;
}
