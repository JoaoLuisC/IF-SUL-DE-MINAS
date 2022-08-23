#include <stdio.h>



void geraMat(int N,int M){
	
	int mat[N][M],bitmat[N][M],i,j,teste=0;
	
	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			printf("insira o valor matriz[%d][%d]: \n",i,j);
			scanf("%d",&mat[i][j]);
		}
	}	
	printf("\n");
	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			printf("%d|",mat[i][j]);
		}
		printf("\n");
	}
	printf("\n");
	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			if(i==j){
				bitmat[i][j]=1;
			}else{
				bitmat[i][j]=0;
			}
		}
		printf("\n");
	}	
	printf("\n");
	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			if(mat[i][j]!=bitmat[i][j]){
				teste=1;
				break;
			}
		}
	}
	if(teste==0){
		printf("eh uma matriz de bits");
	}else{
		printf("nao eh uma matriz de bits");
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