#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

void rdna (char *DNA){
	
	system("cls");
	char RNA[50];
	int i,d=1;
	
	
	for(i=0;i<50;i++){
		
			if(DNA[i]=='A' || DNA[i]=='a' ){
				RNA[i]='T';
				DNA[i]='A';
			}else if(DNA[i]=='T' || DNA[i]=='t' ){
				RNA[i]='A';
				DNA[i]='T';
			}else if(DNA[i]=='C' || DNA[i]=='c' ){
				RNA[i]='G';
				DNA[i]='C';
			}else if(DNA[i]=='G' || DNA[i]=='g' ){
				RNA[i]='C';
				DNA[i]='G';
			}	
	}
	
	for(i=0;i<50;i++){
		
		if(DNA[i] == 'A' || RNA[i] == 'A' || DNA[i] == 'T' || RNA[i] == 'T' || DNA[i] == 'C' || RNA[i] == 'C' || DNA[i] == 'G' || RNA[i] == 'G'){
			if(d<10){
				printf("%d-  DNA:%c      RNA:%c\n",d,DNA[i],RNA[i]);
			}else{
				printf("%d- DNA:%c      RNA:%c\n",d,DNA[i],RNA[i]);
			}
		}
		d++;
	}

}

int main(){
	
	char DNA[50];
	int i;
	
	gets(DNA);

	rdna(DNA);
	
	return 0;
}


