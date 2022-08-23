#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void geraMat(int N,int M){
	
	int mat[N][M],i,j;
	
	srand(time(NULL));
	
	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			mat[i][j]=rand()%10;
			printf("%d|",mat[i][j]);
		}
		printf("\n");
	}	
	
	printf("\n");
	
	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			if(i==j){
				printf("%d|",mat[i][j]);
			}
		}
	}
	
}

int main(){
	
	int N,M;
	
	
	printf("Digite o numero de linhas : ");
	scanf("%d",&N);
	printf("Digite o numero de colunas: ");
	scanf("%d",&M);
	
	geraMat(N,M);
	
	return 0;
}
