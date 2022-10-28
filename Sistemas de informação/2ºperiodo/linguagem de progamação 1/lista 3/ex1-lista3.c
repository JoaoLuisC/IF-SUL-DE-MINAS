#include <stdio.h>
#include <string.h>

typedef struct{
	
	char nome[40];
	char genero[40];
	int integrantes;
	int ranking;
	
}tbanda;
int qtd=0;

//ADD BANDAS;
void addBanda(tbanda b[]){
	printf("Nome da banda:");
	fflush(stdin);// limpa o buffer do teclado
	gets(b[qtd].nome);
	printf("Genero da banda:");
	fflush(stdin);// limpa o buffer do teclado
	gets(b[qtd].genero);
	printf("Qtde de integrantes:");
	scanf("%d",&b[qtd].integrantes);
	printf("Ranking da banda:");
	scanf("%d",&b[qtd].ranking);
	qtd++;
}

//LISTAR BANDAS;
void listaBandas(tbanda b[]){
	int i;
	for(i=0;i<qtd;i++){
		printf("** Banda %d **\n",i+1);
		printf("Nome:%s\n",b[i].nome);
		printf("Genero:%s\n",b[i].genero);
		printf("Integrantes:%d\n",b[i].integrantes);
		printf("Ranking:%d\n",b[i].ranking);
		printf("------------------------\n");
	}
}

//FILTRO RANKING;
void filtroRanking(tbanda b[],int busca){
	
	int i;
	
	for(i=0;i<qtd;i++){
		if(busca==b[i].ranking){
			printf("** Banda %d **\n",i+1);
			printf("Nome:%s\n",b[i].nome);
			printf("Genero:%s\n",b[i].genero);
			printf("Integrantes:%d\n",b[i].integrantes);
			printf("Ranking:%d\n",b[i].ranking);
			printf("------------------------\n");
		}
	}	
}

//FILTRO GENERO;
void filtroGenero(tbanda b[],char genBusca[40]){
	
	int i;
	char genAux[40];
	
	for(i=0;i<qtd;i++){
		strcpy(genAux,b[i].genero);
		strupr(genAux);
		if(strcmp(genBusca,genAux)==0){
			printf("** Banda %d **\n",i+1);
			printf("Nome:%s\n",b[i].nome);
			printf("Genero:%s\n",b[i].genero);
			printf("Integrantes:%d\n",b[i].integrantes);
			printf("Ranking:%d\n",b[i].ranking);
			printf("------------------------\n");
		}
	}

}

//FILTRO NOME;
int filtroNome(tbanda b[],char nomeBusca[40]){
	int i;
	char nomeAux[40];
	for(i=0;i<qtd;i++){
		strcpy(nomeAux,b[i].nome); 
		strupr(nomeAux);
		if(strcmp(nomeBusca,nomeAux)==0){
			printf("** Banda %d **\n",i+1);
			printf("Nome:%s\n",b[i].nome);
			printf("Genero:%s\n",b[i].genero);
			printf("Integrantes:%d\n",b[i].integrantes);
			printf("Ranking:%d\n",b[i].ranking);
			printf("------------------------\n");
			return i;
		}
	}
	return -1;
}

//REMOVE BANDA;
void removeBanda(tbanda b[],char nomeBusca[40]){
	
	int posicao, resp;
	
	posicao =  filtroNome(b,nomeBusca);
	
	if(posicao== -1){
		printf("Banda nao encontrada\n");
		return;
	}
	printf("Tem certeza que deseja remover?[1-Sim|2-Nao]");
	scanf("%d",&resp);
	if(resp==1){
		b[posicao] = b[qtd-1]; 
		qtd--;
	}
	else
	 printf("Operacao cancelada\n");
	
}
//SALVAR ARQUIVOS;
void salvaArquivo(tbanda bandas[]){
	
	FILE *arq;
	int i=0;
	arq=fopen("dadosBandas.txt","wb");
	fwrite(&bandas[i],sizeof(tbanda),qtd,arq);
	printf("Dados salvos com sucesso\n");
	fclose(arq);
	
}

//CARREGAR ARQUIVOS;
void carregaArquivo(tbanda bandas[]){
	FILE *arq;
	arq=fopen("dadosBandas.txt","rb");
	if(arq==NULL){
	  printf("Arquivo nao encontrado :(\n");
	  return;
	  }// fim if
	 while(fread(&bandas[qtd],sizeof(tbanda),1,arq) >0 )
	      qtd++;  
	 printf("Dados carregados com sucesso !\n");
	fclose(arq);
}

//MENU;
int menu(){
	int opcao;
	printf("*** Sistema de Cadastro Rock4You ***\n");
	printf("1- Cadastrar\n");
	printf("2- Listar\n");
	printf("3- Filtro por ranking\n");
	printf("4- Filtro por genero\n");
	printf("5- Filtro por nome\n");
	printf("6- Remover banda\n");
	printf("0 - Sair\n");
	scanf("%d",&opcao);
	return opcao;
}

int main(){
	
	
	tbanda bandas[100];
	int opcao,busca;
	char genBusca[40],nomeBusca[40];
	
	carregaArquivo(bandas);
	
	do{
		
		opcao = menu();
		
		switch(opcao){
			case 1:
				addBanda(bandas);
			break;
			//-----------
			case 2:
				listaBandas(bandas);
			break;
			//-----------
			case 3:
				printf("Filtro por ranking: ");
				scanf("%d",&busca);
				filtroRanking(bandas,busca);
			break;
			//-----------
			case 4:
				printf("Filtro por genero: ");
				fflush(stdin);
				gets(genBusca);
				strupr(genBusca);
				filtroGenero(bandas,genBusca);				
			break;
			//-----------
			case 5:
				printf("Filtro por nome: ");
				fflush(stdin);
				gets(nomeBusca);
				strupr(nomeBusca);
				if(filtroNome(bandas,nomeBusca)==2){
					printf("banda nao encontrada");
				}else{
					printf("banda encontrada");
				}	
			break;
			//-----------
			case 6:
				printf("Nome da banda:");
		 		fflush(stdin);
				gets(nomeBusca);
				strupr(nomeBusca);
				removeBanda(bandas, nomeBusca);
			break;
			//-----------
			case 0:
				printf("Saindo...\n");
				salvaArquivo(bandas);				
			break;
			//-----------
			default: printf("Opcao invalida\n");
			
		}
		
		getch();
		system("cls");
		
		
	}while(opcao!=0);
	
	return 0;
}
