#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void geraMat(int N,int M){
	
	int mat1[N][M],mat2[N][M],somaMat[N][M],i,j;
	
	srand(time(NULL));
	
	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			mat1[i][j]=rand()%10;
			mat2[i][j]=rand()%10;
		}
	}	

	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			printf("%d|",mat1[i][j]);
		}
		printf("\n");
	}	
	printf("\n");
	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			printf("%d|",mat2[i][j]);
		}
		printf("\n");
	}
	printf("\n");
	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			somaMat[i][j] = mat1[i][j]+mat2[i][j];
			printf("%d|",somaMat[i][j]);
		}
		printf("\n");
	}
	
}

int main(){
	
	int N=3,M=3,J,K;
	
	printf("Digite a ordem da matriz 1: ");
	scanf("%d%d",&N,&M);
	printf("Digite a ordem da matriz 2: ");
	scanf("%d%d",&J,&K);
	
	if(N==J && M==K){
		geraMat(N,M);
	}else{
		printf("matriz de ordens diferentes.");
	}
	
}
