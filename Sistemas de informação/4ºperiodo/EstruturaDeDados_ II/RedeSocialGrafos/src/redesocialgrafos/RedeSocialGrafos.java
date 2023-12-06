package redesocialgrafos;

import java.util.Scanner;


public class RedeSocialGrafos {

    static int menu() {
        Scanner scanner = new Scanner(System.in);
        int op;
        System.out.println("1-Adicionar Usuario");
        System.out.println("2-Adicionar Amigo");
        System.out.println("3-Lista de Contatos");
        System.out.println("4-Listar Conexoes de um Usuario");
        System.out.println("5-Alcance de Contato");
        System.out.println("0-Sair");
        op = scanner.nextInt();
        return op;
    }
    
    public static void main(String[] args) {
        grafo grafo = new grafo();
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        
        do {
            op = menu();
            switch (op) {
                case 1:
                    System.out.println("Digite o nome do Usuario:");
                    String nome = scanner.nextLine();
                    grafo.adicionarVertice(nome);
                    break;

                case 2:
                    System.out.println("Amigos:");
                    System.out.println("Digite o nome do Usuario:");
                    String usuario = scanner.nextLine();
                     System.out.println("Digite o nome do Amigo:");
                    String amigo = scanner.nextLine();
                    grafo.adicionarAresta(usuario, amigo);
                break;

                case 3:
                    grafo.imprimirGrafo();
                break;

                case 4:
                    System.out.println("Conexões:");
                    usuario = scanner.nextLine();
                    grafo.confereConexoes(usuario);
                break;

                case 5:
                    System.out.println("Contatos");
                    System.out.println("Contato 1:");
                    usuario = scanner.nextLine();
                    System.out.println("Contato 2:");
                    amigo = scanner.nextLine();

                    if (grafo.alcance(usuario, amigo)) {
                        System.out.println("Existe Caminho!");
                    } else {
                        System.out.println("Nao Existe Caminho!");
                    }
                break;

                case 0:
                    System.out.println("Saindo....");
                    grafo.salvarGrafo();
                break;
            }
        } while (op != 0);

    }
}
    

