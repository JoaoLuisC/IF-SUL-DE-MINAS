#include <stdio.h>

int main(){
	
	float S,IR;	//S = SALARIO , IR = IMPOSTO RETIDO
	
	scanf("%f",&S);
	
	if(S >= 1903.99 && S <= 2826.65){
		
		IR = (S*7.5)/100;
		
	}if(S >= 2826.66 && S <= 3751.05){
		
		IR = (S*15)/100;
		
	}if(S >= 3751.06 && S <= 4664.68){
		
		IR = (S*22.5)/100;
		
	}if(S >= 4664.68){
		
		IR = (S*27.5)/100;
		
	}
	
	printf("O valor a ser retido eh de: %.2f\n",IR);
	
	return 0;
}