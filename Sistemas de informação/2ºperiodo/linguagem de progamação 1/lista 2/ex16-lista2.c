#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void geraMat(int m[][100],int lin,int cols){
	
	int i,j;
	
	srand(time(NULL));
	
	for(i=0;i<lin;i++){
		for(j=0;j<cols;j++){
			m[i][j]=rand()%10;
			printf("%d|",m[i][j]);
		}
		printf("\n");
	}	
	
}

void det2(int m[][100],int lin,int cols){
	
	int i,j,det=1;

	
	for(i=0;i<lin;i++){
		for(j=0;j<cols;j++){
			if(i==j){
				det*=m[i][j];
			}
		}
	}
	
	printf("O determinante eh: %d",det);
}

void detnew3(int m[][100],int lin, int cols){
	
	int i,j,k=0;
	cols+=2;

	for(i=0;i<lin;i++){
		for(j=3;j<cols;j++){
			m[i][j]=m[i][k];
			k++;
		}
		k=0;
	}
}

void det3(int m[][100],int lin,int cols){
	
	int i,j,k,det[3];//k konstante pra aumenta o det;

	for(k=0;k<3;k++){
		for(i=0;i<lin;i++){
			for(j=0;j<cols;j++){
				
				if(i+k==j+){
					det*=m[i][j];
					
				}
			}
		}
		
	}

	
	
}


int main(){
	
	int m[100][100],o,lin,cols;
	
	
	printf("Digite a ordem da matriz: ");
	scanf("%d",&o);
	
	lin  = o;
	cols = o;
	
	geraMat(m,lin,cols);
	
	switch(o){
		
		case 2:
			det2(m,lin,cols);
		break;
		
		case 3:
			detnew3(m,lin,cols);
			det3()
		break;
		
	}

	return 0;
}

/*





*/