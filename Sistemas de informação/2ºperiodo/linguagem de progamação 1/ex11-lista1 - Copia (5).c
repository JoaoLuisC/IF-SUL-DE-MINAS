#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void lingP (char *vet,int n){
	
	int i,j=0,num=0,ants=0,dps=2;
	char descP[n];
	vet[n+1]= ' ';
	
	for(i=1;i<n;i++){
		
		if (vet[ants] != 'p' && vet[dps] == 'p' && vet[i] =='p'){
			descP[j]=dps;
			j++;
			num++;	
		}else if(vet[ants] == 'p' && vet[dps] != 'p' && vet[i] =='p'){

			num++;
		}else if(vet[ants] == 'p' && vet[dps] == 'p'){
			descP[j] = vet[i];
			j++;
			num++;
		}else if(vet[ants] == 'p' && vet[dps] == ' '){
			descP[j] = vet[i];
			j++;
			num++;
		}else if(vet[ants] != 'p' && vet[dps] == 'p'){
			descP[j] = vet[i];
			j++;
			num++;
		}else if(vet[ants] == 'p' && vet[dps]!='p'){
			descP[j] = vet[i];
			j++;
			num++;
		}	
		
		ants++;
		dps++;
	}
	
	for(i=0;i<num;i++){
		printf("%c",descP[i]);
	}
	
	
}


int main (){
	
	char vetp[300];
	int n;
	
	gets(vetp);
	n=strlen(vetp);
	
	lingP(vetp,n);
	
	
	return 0;
}

/*

for(i=1;i<n;i++){
		
		if(vet[i--] == 'p' && vet[i++] == 'p'){
			descP[j] = vet[i];
			j++;
			num++;
		}else if(vet[i--] == 'p' && vet[i++] == ' '){
			descP[j] = vet[i];
			j++;
			num++;
		}else if(vet[i--] != 'p' && vet[i++] == 'p'){
			descP[j] = vet[i];
			j++;
			num++;
		}	
		
	}
	
	for(i=0;i<num;i++){
		printf("%s",descP[i]);
	}

*/
