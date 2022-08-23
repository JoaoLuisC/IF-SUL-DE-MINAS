#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void geraMat(int N,int M,int X){
	
	int mat[N][M],flag=0,i,j;
	
	srand(time(NULL));
	
	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			mat[i][j]=rand()%100;
			if(mat[i][j]==X){
				flag++;
			}
			printf("%d|",mat[i][j]);
		}
		printf("\n");
	}	

	printf("foram encontrados %d vezes o numero na matris",flag);
	
}

int main(){
	
	int X,N,M;
	
	printf("digite um numero: ");
	scanf("%d",&X);
	
	printf("Digite o numero de linhas : ");
	scanf("%d",&N);
	printf("Digite o numero de colunas: ");
	scanf("%d",&M);
	
	geraMat(N,M,X);
	
	return 0;
}
