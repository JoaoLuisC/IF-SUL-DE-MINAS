#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void dado (int n){
	
	int vet[n],i,j=1;
	int flag1=0,flag2=0,flag3=0,flag4=0,flag5=0,flag6=0,res[5];
	
	srand(time(NULL));
	
	for(i=0;i<n;i++){
		
		vet[i]=rand()%6+1;
		
		if(vet[i]==1){
			flag1++;
			res[0]=flag1;
		}else if(vet[i]==2){
			flag2++;
			res[1]=flag2;
		}else if(vet[i]==3){
			flag3++;
			res[2]=flag3;
		}else if(vet[i]==4){
			flag4++;
			res[3]=flag4;
		}else if(vet[i]==5){
			flag5++;
			res[4]=flag5;
		}else if(vet[i]==6){
			flag6++;
			res[5]=flag6;
		}	
	}
	


	printf("\n");
	
	for(i=0;i<6;i++){
		printf("Dado %d:%d\n",j,res[i]);
		j++;
	}
	
	

	
	
}
int main(){
	
	int n;
	
	printf("Quantas vezes rolou o dado:");
	scanf("%d",&n);
	
	dado(n);
	
	return 0;
}