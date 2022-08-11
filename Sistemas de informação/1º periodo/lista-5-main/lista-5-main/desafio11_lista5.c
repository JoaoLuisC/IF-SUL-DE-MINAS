#include <stdio.h>

int CustoViagem(int comprimento,int distancia_pedagio,int custoKm,int custo_pedagio){
	
	int CustoTotal;
		
	CustoTotal = ((comprimento/distancia_pedagio)*custo_pedagio)+(custoKm*comprimento);
	
	return CustoTotal;
}


int main(){
	
	int DistP,Compri,CustoKM,CustoP,CustoTotal;
	
	printf("Digite o comprimento da estrada: ");
	scanf("%d",&Compri);
	
	printf("Digite a distancia entre cada pedagio: ");
	scanf("%d",&DistP);
	
	printf("Digite o custo por km: ");
	scanf("%d",&CustoKM);
	
	printf("Digite o custo do pedagio: ");
	scanf("%d",&CustoP);
	
	CustoTotal = CustoViagem(Compri,DistP,CustoKM,CustoP);
	
	printf("O custo total da viagem eh de: %d",CustoTotal);
	
	return 0;
}
