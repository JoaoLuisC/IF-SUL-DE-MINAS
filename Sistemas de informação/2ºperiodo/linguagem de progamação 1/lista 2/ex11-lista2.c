#include <stdio.h>
#include <stdlib.h>
#include <time.h>



void geraMat(int m[][100],int lin,int cols){
	
	int i,j,x,m2[100][100];
	
	srand(time(NULL));
	
	printf("Digite uma escalar:");
	scanf("%d",&x);
	
	for(i=0;i<lin;i++){
		for(j=0;j<cols;j++){
			m[i][j]=rand()%10;
			m2[i][j]=m[i][j]*x;
		}
	}
		
	for(i=0;i<lin;i++){
		for(j=0;j<cols;j++){
			printf("%d|",m[i][j]);
		}
		printf("\n");
	}
	printf("\n");
	for(i=0;i<lin;i++){
		for(j=0;j<cols;j++){
			printf("%d|",m2[i][j]);
		}
		printf("\n");
	}		
}

int main(){
	
	int mat[100][100],lin,cols;
	
	printf("Digite o numero de linhas : ");
	scanf("%d",&lin);
	printf("Digite o numero de colunas: ");
	scanf("%d",&cols);
		
	geraMat(mat,lin,cols);
	
	return 0;
}