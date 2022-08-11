#include <stdio.h>

int CalcMaior(float num1,float num2,float num3,float num4,float num5){
	
	int Maior=0;
		
	if(num1>Maior){
		Maior = num1;
	}
	
	if(num2 > Maior){
		Maior = num2;
	}
	
	if (num3 > Maior){
		Maior = num3;
	}
	if(num4> Maior){
		Maior = num4;
	}
	if(num5>Maior){
		Maior = num5;
	}
	return Maior;
		
}

int CalcMenor(float num1,float num2,float num3,float num4,float num5){
	
	int Menor=0;
		
	if(Menor < num1){
		Menor = num1;
	}
	if(num2 < Menor){
		Menor = num2;
	}
	if (num3 < Menor){
		Menor = num3;
	}
	if(num4 < Menor){
		Menor = num4;
	}
	if(num5 < Menor){
		Menor = num5;
	}
	return Menor;
}

int ResSamba(float num1,float num2,float num3,float num4,float num5){
	
	float maior,menor,soma;
	
	maior = CalcMaior (num1,num2,num3,num4,num5);
	menor = CalcMenor (num1,num2,num3,num4,num5);
	
	soma = (num1+num2+num3+num4+num5)-maior-menor;
	
	return soma;
	
}

int main(){
	
	float num1,num2,num3,num4,num5,res;
	
//prints	
	{	
	printf("Digite a primeira nota: \n");
	scanf("%f",&num1);
	
	printf("Digite a segunda nota: \n");
	scanf("%f",&num2);
	
	printf("Digite a terceira nota: \n");
	scanf("%f",&num3);
	
	printf("Digite a quarta nota: \n");
	scanf("%f",&num4);
	
	printf("Digite a quinta nota: \n");
	scanf("%f",&num5);
	}
//fim prints	
	
	res = ResSamba(num1,num2,num3,num4,num5);
	
	printf("A soma das notas da escola de samba eh: %.1f",res);
	
	return 0;	
}
