#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void sorteio (int n){

	int i,vet[n],escolha,erro,certo,flag=0;
	
	srand(time(NULL));

	for(i=0;i<n;i++){		
		vet[i]=rand()%50;
	}
	
	printf("Escolha um numero: \n");
	scanf("%d",&escolha);

	certo = -1;

	for(i=0;i<n;i++){
		if(escolha!=vet[i]){
			erro=-1;
		}else{
			certo=2;
			flag++;		
		}	
	}
	
	if(erro==certo){
		printf("voce nao acertou nenhum numero.");		
	}else{
		printf("voce acertou %d vezes\n",flag);
	}
}
int main(){
	
	int n;
	
	printf("Digite um numero para o limite do vetor: \n");
	scanf("%d",&n);
	printf("\n");

	sorteio(n);
	
	return 0;
}

