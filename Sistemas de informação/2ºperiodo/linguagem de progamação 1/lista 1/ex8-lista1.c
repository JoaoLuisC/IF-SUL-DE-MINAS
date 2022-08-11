#include <stdio.h>
#include <string.h>

int main(){
	
	char vet[100];
	int i,n;
	
	gets(vet);
	
	n = strlen(vet);
	
	for(i=n;i>=0;i--){
		
		printf("%c",vet[i]);
		
	}
		
	return 0;
}