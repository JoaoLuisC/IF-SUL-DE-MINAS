#include <stdio.h>

int main(){
	
	int i=1,continua,qtdF,alunoC=0;
	float salaMin,rendF,rendPC;
	
	printf("Escreva o salario minimo: \n");
	scanf("%f",&salaMin);
	
	
	do{
		
		printf("Escreva a renda familiar da familia [%d]: \n",i);
		scanf("%f",&rendF);
		
		printf("Escreva a quantidade de pessoas q moram com a familia [%d]: \n",i);
		scanf("%d",&qtdF);
		
		rendPC = rendF/qtdF;
		
		if(rendPC < (salaMin/2)){
			
			printf("A familia do Aluno [%d] recebera auxilio.",i);
			
			alunoC++;
		}
		
		i++;
		
		printf("Para parar digite [0]: \n");
		scanf("%d",&continua);	
		
	}while(continua!=0);
	
	printf("A quantidade de alunos q recebera auxilio sera de: %d",alunoC);
		
	return 0;
}
