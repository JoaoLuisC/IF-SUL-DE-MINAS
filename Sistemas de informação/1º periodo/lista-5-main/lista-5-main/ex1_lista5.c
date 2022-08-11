#include <stdio.h>

int ehPar(int num){
	
	if(num%2==0)
		return 1;
	else
		return 0;
	
}

int main(){
	
	int num,res;
	
	printf("Digite um numero: \n");
	scanf("%d",&num);
	
	res = ehPar(num);
	
	if(res == 1)
		printf("O numero eh Par\n");
	else
		printf("O numero eh Impar\n");
		
	
	return 0;
	
}