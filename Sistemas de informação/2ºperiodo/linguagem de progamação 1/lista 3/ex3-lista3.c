#include <stdio.h>
#include <string.h>

typedef struct{
	
	int matricula;
	char nome[40];
	float n1,n2,n3;// n = nota; 
	float media;
	
		
}taluno;
int qtd=0;

//ADICIONAR ALUNOS;
void addAlunos(taluno a[]){
	float n1,n2,n3,media;
	
	printf("Numero de matricula: ");
	scanf("%d",&a[qtd].matricula);
	
	printf("Nome do Aluno:");
	fflush(stdin);
	gets(a[qtd].nome);
	
	printf("Nota 1: ");
	scanf("%f",&a[qtd].n1);
	printf("Nota 2: ");
	scanf("%f",&a[qtd].n2);
	printf("Nota 3: ");
	scanf("%f",&a[qtd].n3);
	
	n1 = a[qtd].n1;
	n2 = a[qtd].n2;
	n3 = a[qtd].n3;
	media = (n1+n2+n3)/3;
	a[qtd].media = media;
	
	if(media>=6){
		printf("media do aluno: %.2f\n",media);
		printf("Aluno Aprovado\n");
	}else{
		printf("media do aluno: %.2f\n",media);
		printf("Aluno Reprovado\n");
	}
	
	qtd++;
}

//SALVAR ARQUIVOS;
void salvaArquivo(taluno aluno[]){
	
	FILE *arq;
	int i=0;
	arq=fopen("dadosAlunos.txt","wb");
	fwrite(&aluno[i],sizeof(taluno),qtd,arq);
	printf("Dados salvos com sucesso\n");
	fclose(arq);
	
}

//CARREGAR ARQUIVOS;
void carregaArquivo(taluno aluno[]){
	FILE *arq;
	arq=fopen("dadosAlunos.txt","rb");
	if(arq==NULL){
	  printf("Arquivo nao encontrado :(\n");
	  return;
	  }// fim if
	 while(fread(&aluno[qtd],sizeof(taluno),1,arq) >0 )
	      qtd++;  
	 printf("Dados carregados com sucesso !\n");
	fclose(arq);
}

//BUSCA ALUNOS;
void buscaNome(taluno a[], char nomeBusca[40]){
	
	int i;
	char buscaAux[40];
	
	for(i=0;i<qtd;i++){	
		strcpy(buscaAux,a[i].nome);
		strupr(buscaAux);
		
		if(strcmp(buscaAux,nomeBusca)==0){
			printf("*** Aluno %d ***\n",i+1);
			printf("Numero de matricula: %d\n",a[i].matricula);
			printf("Nome do Aluno: %s\n",a[i].nome);	
			printf("Nota 1: %.2f\n",a[i].n1);
			printf("Nota 2: %.2f\n",a[i].n2);
			printf("Nota 3: %.2f\n",a[i].n3);
			printf("Media do Aluno: %.2f\n",a[i].media);
			printf("------------------------\n");
		}	
	}	
}

//BUSCA MATRICULA;
void buscaMatricula(taluno a[], int matriculaBusca){
	
	int i;
	int buscaAux;
	
	for(i=0;i<qtd;i++){
		buscaAux = a[i].matricula;
		
		if(buscaAux == matriculaBusca){
			printf("*** Aluno %d ***\n",i+1);
			printf("Numero de matricula: %d\n",a[i].matricula);
			printf("Nome do Aluno: %s\n",a[i].nome);	
			printf("Nota 1: %.2f\n",a[i].n1);
			printf("Nota 2: %.2f\n",a[i].n2);
			printf("Nota 3: %.2f\n",a[i].n3);
			printf("Media do Aluno: %.2f\n",a[i].media);
			printf("------------------------\n");
		}
		
	}
	
}

//MAIOR MEDIA;
void maiorMedia(taluno a[]){
	
	int i,numAluno;
	float mediaAux;
	
	mediaAux=a[0].media;
	
	for(i=0;i<qtd;i++){
		
		if(a[i].media > mediaAux){
			mediaAux=a[i].media;
			numAluno = i;
		}
		
	}
	
	printf("*** maior media ***\n");
	printf("\n");
	printf("Numero de matricula: %d\n",a[numAluno].matricula);
	printf("Nome do Aluno: %s\n",a[numAluno].nome);	
	printf("Nota 1: %.2f\n",a[numAluno].n1);
	printf("Nota 2: %.2f\n",a[numAluno].n2);
	printf("Nota 3: %.2f\n",a[numAluno].n3);
	printf("Media do Aluno: %.2f\n",a[numAluno].media);
	printf("------------------------\n");
}

//ALUNOS APROVADOS/REPROVADOS;
void mediaAlunos(taluno a[]){
	
	int i;
	printf("ALUNOS APROVADOS\n");
	printf("\n");
	for(i=0;i<qtd;i++){
		if(a[i].media>=6){
			printf("*** Aluno %d ***\n",i+1);
			printf("Numero de matricula: %d\n",a[i].matricula);
			printf("Nome do Aluno: %s\n",a[i].nome);	
			printf("Nota 1: %.2f\n",a[i].n1);
			printf("Nota 2: %.2f\n",a[i].n2);
			printf("Nota 3: %.2f\n",a[i].n3);
			printf("Media do Aluno: %.2f\n",a[i].media);
			printf("------------------------\n");
		}
	}	
	printf("\n");
	printf("ALUNOS REPROVADOS\n");
	printf("\n");
	for(i=0;i<qtd;i++){
		if(a[i].media<6){
			printf("*** Aluno %d ***\n",i+1);
			printf("Numero de matricula: %d\n",a[i].matricula);
			printf("Nome do Aluno: %s\n",a[i].nome);	
			printf("Nota 1: %.2f\n",a[i].n1);
			printf("Nota 2: %.2f\n",a[i].n2);
			printf("Nota 3: %.2f\n",a[i].n3);
			printf("Media do Aluno: %.2f\n",a[i].media);
			printf("------------------------\n");
		}
	}	
	
}

//MENU;
int menu(){
	int opcao;	
	printf("*** Alunos IFMG ***\n");
	printf("1- Adicionar alunos\n");
	printf("2- Buscar por nome\n");
	printf("3- Buscar por Matricula\n");
	printf("4- Aluno com maior media\n");
	printf("5- Alunos Aprovados/Reprovados\n");
	printf("0- Sair \n");	
	scanf("%d",&opcao);
	return opcao;
}

int main(){
	
	taluno alunos[100]; 
	int opcao;
	char nomeBusca[40];
	int matriculaBusca;
	
	
	carregaArquivo(alunos);
	
	do{
		
		opcao = menu();
		switch(opcao){
			
			case 1:
				addAlunos(alunos);
			break;
			
			case 2:
				printf("Buscar por nome: ");
				fflush(stdin);
				gets(nomeBusca);
				strupr(nomeBusca);
				buscaNome(alunos,nomeBusca);
			break;
			
			case 3:
				printf("Busca por Matricula: ");
				scanf("%d",&matriculaBusca);
				buscaMatricula(alunos,matriculaBusca);
			break;
			
			case 4:
				maiorMedia(alunos);
			break;
			
			case 5:
				mediaAlunos(alunos);
			break;
			
			case 0:
				printf("Saindo...\n");
				salvaArquivo(alunos);
			break;
			
			
			default: 
			printf("Opcao invalida\n");
			return 0;
			
		}
		
		getch();
		system("cls");
		
	}while(opcao!=0);
	
	return 0;
}