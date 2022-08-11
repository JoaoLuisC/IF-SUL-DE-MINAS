#include <stdio.h>

float ImpRet(float S){
	
	float IR;	//IR = IMPOSTO RETIDO
	
	if(S >= 1903.99 && S <= 2826.65){
		
		IR = (S*7.5)/100;
		
	}if(S >= 2826.66 && S <= 3751.05){
		
		IR = (S*15)/100;
		
	}if(S >= 3751.06 && S <= 4664.68){
		
		IR = (S*22.5)/100;
		
	}if(S >= 4664.68){
		
		IR = (S*27.5)/100;
		
	}
	
	return IR;
}

int main(){
	
	int qtdF; // qtdF = QUANTIDADE  DE FUNCIONARIOS
	float soma=0;
	
	
	scanf("%d",&qtdF);
	
	int F[qtdF],i; // F = FUNCIONARIOS
	
	
	for(i=0;i<qtdF;i++){
		
		printf("O funcionario %d, recebe de salario: ",i+1,"\n");
		scanf("%d",&F[i]);
			
		soma+= ImpRet(F[i]);
	}
	
	for(i=0;i<qtdF;i++){
		
		printf("|%.2f|",ImpRet(F[i]) );
		
	}
	
	printf("\nA soma de todos os impostos retidos eh de: %.2f",soma);
	
	return 0;
}

/*	for(i=0;i<qtdF;i++){
		
		printf("|%.2f|",F[i]);
		
	}
*/