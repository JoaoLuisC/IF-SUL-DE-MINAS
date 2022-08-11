#include <stdio.h>

int result (float nota1, float nota2, float nota3, int frequencia){
	
	float media;
	
	media = (nota1+nota2+nota3)/3;
	
	if(media>=6 && frequencia>=75){
		return 1;
	}else if(media<6 && media>4 && frequencia >=75){
		return 2;
	}else if(media<4 || frequencia<75){
		return 3;
	}
	
	
}

int main (){
	
	float num1,num2,num3;
	int frequencia,res;
	
	printf("entre com as 3 notas: ");
	scanf("%f%f%f",&num1,&num2,&num3);
	
	printf("Entre com a frequencia do aluno: ");
	scanf("%d",&frequencia);
	
	if(res=(result(num1,num2,num3,frequencia)==1)){
		printf("APROVADO");
	}else if(res=(result(num1,num2,num3,frequencia)==2)){
		printf("FINAL");
	}else if (res=(result(num1,num2,num3,frequencia)==3)){
		printf("REPROVADO");
	}
	
	return 0;	
	
}