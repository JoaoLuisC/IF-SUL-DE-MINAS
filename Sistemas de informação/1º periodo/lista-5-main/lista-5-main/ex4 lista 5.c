#include <stdio.h>

int febo(int num){
	
	int res,i,B,N;
	
	B=0;
	N=1;
	
	if(num==1){
		res=1;
		return res;
	}else{
		for(i=0;i<=num;i++){
			
			res = B + N; 
			B = N;
			N = res;
		     
		}
		return res;
	}

}
	
	
int main(){
	
	int num,res;
	
	scanf("%d",&num);
	
	res = febo(num);
		
	printf("O %d termo da sequencia de Fibonacci eh : %d",num,res);
	
	return 0;
	
}