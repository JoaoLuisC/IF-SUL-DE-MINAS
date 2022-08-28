#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void geraMat(int lin,int cols){
	
	int mat[lin][cols],i,j,matT[cols][lin],x=0;
	
	srand(time(NULL));
	
	for(i=0;i<lin;i++){
		for(j=0;j<cols;j++){
			mat[i][j]=rand()%100;
			printf("%d|",mat[i][j]);
		}
		printf("\n");
	}	
	
	printf("\n");
	
	for(i=0;i<cols;i++){
		for(j=0;j<lin;j++){
			matT[i][j]=mat[j][i];
			printf("%d|",matT[i][j]);
		}
			printf("\n");
	}


	
}

int main(){
	
	int X,N,M;
	
	printf("Digite o numero de linhas : ");
	scanf("%d",&N);
	printf("Digite o numero de colunas: ");
	scanf("%d",&M);
	
	geraMat(N,M);
	
	return 0;
}