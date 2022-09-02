#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void scanMat(int m[][100],int lin,int cols){
	
	int i,j;
	
	for(i=0;i<lin;i++)
		for(j=0;j<cols;j++){
			printf("matriz[%d][%d]: ",i,j);
			scanf("%d",&m[i][j]);
			system("cls");
		}
			
	system("cls");
}

void printMat(int m[][100],int lin,int cols){
	
	int i,j;
	
	for(i=0;i<lin;i++){
		for(j=0;j<cols;j++){
			printf("%d|",m[i][j]);
		}
		printf("\n");
	}		
	
}

void multiMat(int m1[2][3],int m2[3][2],int lin1,int lin2,int cols1,int cols2){
	
	int i,j,k,l=0; //  k = lin2 ; l = cols1;
	
	int m3[lin1][cols2];
	
	for(i=0;i<lin1;i++)
		for(j=0;j<cols2;j++)
			m3[i][j]=0;

	
	for(i=0;i<lin1;i++){
			
		for(j=0;j<cols1;j++){
			l=0;
			for(k=0;k<lin2;k++){
				m3[i][l]+=(m1[i][j]*m2[k][l]);
				printf("m3[%d][%d]+=m1[%d][%d]*m2[%d][%d]: %d ",i,j,i,l,k,j,m3[i][l]);
				system("pause");
				l++;
			}
			printf("\n");
		}
	}
	
	printf("\n");
	printMat(m3,lin1,cols2);
	

} 

int main(){
	
	int m1[2][3]={1,0,2,-1,3,1},m2[3][2]={3,1,2,1,1,0},newM[100][100],lin1,cols1,lin2,cols2;
	
	printf("Digite o numero de linhas da primeira matriz: ");
	scanf("%d",&lin1);
	printf("Digite o numero de colunas da primeira matriz: ");
	scanf("%d",&cols1);
	
	printf("Digite o numero de linhas da segunda matriz: ");
	scanf("%d",&lin2);
	printf("Digite o numero de colunas da segunda matriz: ");
	scanf("%d",&cols2);
	
	system("cls");
	
	//scanMat(m1,lin1,cols1);
	//scanMat(m2,lin2,cols2);
		
	//printMat(m1,lin1,cols1);
	//printf("\n");
	//printMat(m2,lin2,cols2);
	int i,j;
	for(i=0;i<lin1;i++){
		for(j=0;j<cols1;j++){
			printf("%d|",m1[i][j]);
		}
		printf("\n");
	}
	
	for(i=0;i<lin2;i++){
		for(j=0;j<cols2;j++){
			printf("%d|",m2[i][j]);
		}
		printf("\n");
	}
		
	multiMat(m1,m2,lin1,lin2,cols1,cols2);	
	return 0;
}