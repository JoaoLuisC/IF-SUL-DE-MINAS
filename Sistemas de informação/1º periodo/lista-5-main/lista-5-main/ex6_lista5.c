#include <stdio.h>

int ehPrimo(int num){
	
	int i,resto=0;
	
	for(i=1;i<=num;i++){
		
		if(num%i==0)
			resto++;
		
	}	
	
	if(resto==2 || resto == 1)
		return 1;
	else
		return 0;
		
}

int qtdPrimo(int num){
	
	int qtdP=0,i,res;
	
	for(i=1;i<=num;i++){
		
		if(ehPrimo(i)==1)
			qtdP++;
			
	}
	
	return qtdP;
	
}

int main(){

	int num,res;
	
	printf("digite o ultimo numero do intervalo entre 1 e n: ");
	scanf("%d",&num);
	
	res= qtdPrimo(num);
	
	printf("A quantidade de primos eh: %d",res);
	
	return 0;
	
}