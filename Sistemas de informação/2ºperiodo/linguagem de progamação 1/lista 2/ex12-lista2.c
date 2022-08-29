#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void geraMat10(int m[][100],int lin,int cols){
	
	int i,j;
	
	srand(time(NULL));
	
	for(i=0;i<lin;i++)
		for(j=0;j<cols;j++)
			m[i][j]=rand()%10;
	
}

void geraMat210(int m[][100],int lin,int cols){
	
	int i,j;
	
	srand(time(NULL));
	
	for(i=0;i<lin;i++)
		for(j=0;j<cols;j++)
			m[i][j]=rand()%9+1;
	
}

void scanMat(int m[][100],int lin,int cols){
	
	int i,j;
	
	for(i=0;i<lin;i++)
		for(j=0;j<cols;j++)
			scanf("%d",&m[i][j]);
			
	
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

void constante(int m[][100],int m2[][100],int lin,int cols){
	
	printMat(m,lin,cols);
	printf("\n");
	printMat(m2,lin,cols);
	printf("\n");
	
	int x,i,j;
	
	printf("digite um numero para a constante: ");
	scanf("%d",&x);
	
	for(i=0;i<lin;i++){
		for(j=0;j<cols;j++){
			m[i][j]+=x;
			m2[i][j]+=x;
		}
	}
	
	printf("\n");
	printMat(m,lin,cols);
	printf("\n");
	printMat(m2,lin,cols);
	
	
}

void somaMat(int m[][100],int m1[][100],int mSoma[][100],int lin,int cols){
	
	printMat(m,lin,cols);
	printf("\n");
	printMat(m1,lin,cols);
	printf("\n");
	
	printf("a soma das matrizes 1 e 2 eh: \n\n");
	
	int i,j;
	
	for(i=0;i<lin;i++)
		for(j=0;j<cols;j++)
			mSoma[i][j]= m[i][j]+m1[i][j];
	
			
	printMat(mSoma,lin,cols);
	
	
}

void subMat(int m[][100],int m1[][100],int mSub[][100],int lin,int cols){ 
	
	printMat(m,lin,cols);
	printf("\n");
	printMat(m1,lin,cols);
	printf("\n");
	
	printf("a subtracao das matrizes 1 e 2 eh: \n\n");
	
	int i,j;
	
	for(i=0;i<lin;i++)
		for(j=0;j<cols;j++)
			mSub[i][j]= m[i][j]-m1[i][j];
	
			
	printMat(mSub,lin,cols);
	
	
}

int main(void){
	
	int m[100][100],m2[100][100],mResultante[100][100],lin,cols,esc1,esc2;
	
	printf("Digite o numero de linhas: ");
	scanf("%d",&lin);
	printf("Digite o numero de colunas: ");
	scanf("%d",&cols);
	
	system("cls");
	
	printf("1- Aleatorizar matriz.\n");
	printf("2- Escrever matriz.\n");
	scanf("%d",&esc1);
	
	switch(esc1){
		
		case 1:
			geraMat10(m,lin,cols);
			geraMat210(m2,lin,cols);
		break;
		
		case 2:
			system("cls");
			printf("escrevendo matriz 1: \n");
			scanMat(m,lin,cols);
			printf("escrevendo matriz 2: \n");
			scanMat(m2,lin,cols);
		break;
	}

	system("cls");
	
	printf("1- somar matrizes.\n");
	printf("2- subtrair matrizes.\n");
	printf("3- adicionar constante matrizes.\n");
	printf("4- imprimir matrizes.\n");
	scanf("%d",&esc2);
	
	system("cls");
		
	switch(esc2){
		
		case 1:
			somaMat(m,m2,mResultante,lin,cols);
		break;	
		
		case 2:
			system("cls");
			subMat(m,m2,mResultante,lin,cols);
		break;	
		
		case 3:
			system("cls");
			constante(m,m2,lin,cols);
		break;	
		
		case 4:
			printMat(m,lin,cols);
			printf("\n");
			printMat(m2,lin,cols);
		break;
		
		default:
			printf("Opcao invalida. \n");
			system("pause;");
			system("cls");
	}
	
	
	return 0;
}