#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int testeATG(char base[]){
	
	int i;
	
	for(i=0;i<100;i++){		
		if(base[i]=='a' && base[i+1]=='t' && base[i+2]=='g')
			return 1;
	}
		
	
	
	return 2;
	
}	

int main(){
	
	int teste;
	char DNA[100];
	
	printf("entre com a base de DNA: ");
	gets(DNA);
	fflush(stdin);
	
	teste=testeATG(DNA);
	
	if(teste==1){
		printf("\nEXISTE");
	}else{
	printf("INEXISTENTE");
	}
	
	return 0;
}

			
/*

if(base[i]=='a' && base[i+1]=='t' && base[i+2]=='g'){
			return 1;

*/