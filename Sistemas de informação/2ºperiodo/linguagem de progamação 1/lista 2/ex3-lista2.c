#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void geraMat(int N,int M){
	
	int mat[N][M],flagMenor,i,j;
	
	srand(time(NULL));
		
	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			mat[i][j]=rand()%100;
			if(i == 0 && j == 0){
				flagMenor=mat[i][j];
			}
			if(mat[i][j]<flagMenor){
				flagMenor = mat[i][j];
			}
			printf("%d|",mat[i][j]);
		}
		printf("\n");
	}	

	printf("O menor numero eh: %d",flagMenor);
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
