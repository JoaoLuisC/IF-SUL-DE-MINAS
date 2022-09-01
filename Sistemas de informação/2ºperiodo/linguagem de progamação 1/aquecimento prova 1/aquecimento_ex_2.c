#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void geraMat100(int m[][100],int o){
	
	int i,j;
	
	srand(time(NULL));
	
	for(i=0;i<o;i++)
		for(j=0;j<o;j++)
			m[i][j]=rand()%100;
	
}

void printMat(int m[][100],int o){
	
	int i,j;
	
	for(i=0;i<o;i++){
		for(j=0;j<o;j++){
			if(m[i][j]<10 && m[i][j]> -10){
				printf("%d |",m[i][j]);
			}else{
				printf("%d|",m[i][j]);
			}
			
		}
		printf("\n");
	}		
	printf("\n");
}

void verifica(int m[][100],int o){
	
	int i,j,impar=0,par=0;
	
	for(i=0;i<o;i++){
		for(j=0;j<o;j++){
			if(m[i][j]%2==0){
				par++;
			}else{
				impar++;
			}
		}
	}
	
	printf("Pares: %d\n",par);
	printf("Impares: %d\n",impar);
	
}



int main(){
	
	int m[100][100],i=0,p=0,ordem;
	
	printf("Digite a ordem: ");
	scanf("%d",&ordem);
	
	geraMat100(m,ordem);
	printMat(m,ordem);
	verifica(m,ordem);
	
	return 0;
}