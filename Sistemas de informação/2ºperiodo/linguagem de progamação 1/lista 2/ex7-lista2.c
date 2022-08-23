#include <stdio.h>

void geraMat(int N){
	
	int mat[N][N],i,j;
	
	for(i=0;i<N;i++){
		for(j=0;j<N;j++){
			if(i==j){
				mat[i][j]=1;
			}else{
				mat[i][j]=0;
			}
			printf("%d|",mat[i][j]);
		}
		printf("\n");
	}	

}

int main(){
	
	int N;
	
	
	printf("Informe o tamanho da matriz indentidade : ");
	scanf("%d",&N);

	geraMat(N);
	
	return 0;
}
