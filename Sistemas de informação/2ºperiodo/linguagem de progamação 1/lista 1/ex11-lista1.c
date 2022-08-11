#include <stdio.h>
#include <string.h>

int main (){
	
	char vetp[1000],descP[1000];
	int n,i,j=0;
	
	gets(vetp);
	n=strlen(vetp);
	
	for(i=1;i<n;i++){
		
		if(vetp[i] == 'p' && vetp[i+1] == 'p'){
			descP[j] = vetp[i];
			j++;
			i+=2;
		}else if(vetp[i] != 'p'){
			descP[j] = vetp[i];
			j++;
		}
	}	

	printf("mensagem descodificada: %s",descP);	
	
	return 0;
}

