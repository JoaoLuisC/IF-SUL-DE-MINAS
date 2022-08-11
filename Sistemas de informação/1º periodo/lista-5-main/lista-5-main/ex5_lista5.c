#include <stdio.h>

int ehPrimo(int num){
	
	int i,resto=0;
	
	for(i=1;i<=num;i++){
		
		if(num%i==0)
			resto++;
		
	}
	
	if(resto==2)
		return 1;
	else
		return 0;
		
	
}

int main(){

	int num;
	
	scanf("%d",&num);
	
	if (ehPrimo(num)==1){
		
		printf("primo");
		
	}else{
		
		printf("nao primo");
	}
	
}