/*
2. Faça um programa que:
a. Crie e leia um vetor com dados de n livros: título (30 letras), autor (15 letras) e
ano, prateleira.
b. Permita cadastrar livros.
c. Procure um livro por título, perguntando ao usuário qual tıtulo deseja buscar,
apresente o nome e em qual prateleira o mesmo se encontra.
d. Mostre os dados de todos os livros cadastrados.
e. Leia um ano e apresente todos os livros mais novos que o ano lido.
*/


#include <stdio.h>
#include <string.h>

typedef struct{
	
	char nome[30];
	char autor[15];
	int ano;
	int prateleira;	
	
}tlivro;
int qtd=0;

//ADICIONAR LIVROS;
void addLivros(tlivro l[]){
	
	printf("Nome do Livro: ");
	fflush(stdin);
	gets(l[qtd].nome);
	printf("Autor do Livro: ");
	fflush(stdin);
	gets(l[qtd].autor);
	printf("Ano de producao do livro: ");
	scanf("%d",&l[qtd].ano);
	printf("Pratileira que esta localizado o Livro: ");
	scanf("%d",&l[qtd].prateleira);
	
	qtd++;
}

//LISTAR LIVROS;
void listarLivros(tlivro l[]){
	
	int i;
	
	for(i=0;i<qtd;i++){
		
		printf("*** Livro %d***\n",i+1);
		printf("Nome do livro: %s\n",l[i].nome);
		printf("Nome do Autor: %s\n",l[i].autor);
		printf("Ano de producao: %d\n",l[i].ano);
		printf("Prateleira do Livro: %d\n",l[i].prateleira);
		printf("------------------------\n");
	}

}

//FILTRAR POR TITULO
void filtroTitulo(tlivro l[], char tituloBusca[30]){
	
	int i;
	char buscaAux[30];
	
	
	for(i=0;i<qtd;i++){
		strcpy(buscaAux,l[i].nome);
		strupr(buscaAux);
		
		if(strcmp(buscaAux,tituloBusca)==0){
			printf("*** Livro %d***\n",i+1);
			printf("Nome do livro: %s\n",l[i].nome);
			printf("Nome do Autor: %s\n",l[i].autor);
			printf("Ano de producao: %d\n",l[i].ano);
			printf("Prateleira do Livro: %d\n",l[i].prateleira);
			printf("------------------------\n");
		}
		
	}
	
}

void filtroAno(tlivro l[],int busca){
	
	int i;
	
	for(i=0;i<qtd;i++){
		
		if(l[i].ano < busca){
			printf("*** Livro %d***\n",i+1);
			printf("Nome do livro: %s\n",l[i].nome);
			printf("Nome do Autor: %s\n",l[i].autor);
			printf("Ano de producao: %d\n",l[i].ano);
			printf("Prateleira do Livro: %d\n",l[i].prateleira);
			printf("------------------------\n");
		}
	}
	
}

//SALVAR ARQUIVOS;
void salvaArquivo(tlivro livro[]){
	
	FILE *arq;
	int i=0;
	arq=fopen("dadosLivraria.txt","wb");
	fwrite(&livro[i],sizeof(tlivro),qtd,arq);
	printf("Dados salvos com sucesso\n");
	fclose(arq);
	
}

//CARREGAR ARQUIVOS;
void carregaArquivo(tlivro livro[]){
	FILE *arq;
	arq=fopen("dadosLivraria.txt","rb");
	if(arq==NULL){
	  printf("Arquivo nao encontrado :(\n");
	  return;
	  }// fim if
	 while(fread(&livro[qtd],sizeof(tlivro),1,arq) >0 )
	      qtd++;  
	 printf("Dados carregados com sucesso !\n");
	fclose(arq);
}

//MENU
int menu(){
	int opcao;
	printf("*** Sistema de Cadastro de Bibliotexa ***\n");
	printf("1- Cadastrar Livro.\n");
	printf("2- Listar livros cadastrados.\n");
	printf("3- Filtro por Titulo.\n");
	printf("4- Filtro por Ano.\n");
	printf("0 - Sair\n");
	scanf("%d",&opcao);
	return opcao;
}

int main(){
	
	tlivro livros[100];
	int opcao , anoBusca;
	char tituloBusca[30];
	
	carregaArquivo(livros);
	
	do{
		
		opcao = menu();
		
		switch(opcao){
			
			case 1:
				addLivros(livros);
			break;
			
			case 2:
				listarLivros(livros);
			break;
			
			case 3:
				printf("Digite o nome do livro para a busca: ");
				fflush(stdin);
				gets(tituloBusca);
				strupr(tituloBusca);
				filtroTitulo(livros,tituloBusca);
			break;
			
			case 4:
				printf("Digite o ano para busca: ");
				scanf("%d",&anoBusca);
				filtroAno(livros,anoBusca);
			break;
			
			case 0:
				printf("Saindo...\n");
				salvaArquivo(livros);
			break;
			
			default: printf("Opcao invalida\n");
			
		}
		
		
		
		getch();
		system("cls");
		
	}while(opcao != 0);
	
	return 0;
}