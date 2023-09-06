package javasorts;

import java.util.Scanner;

//4,2,3,6,10,9,7,5,11,1

public class Menus {
    
    public static int menuEntrada(int op) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nMenu Gerenciador de dados");
        System.out.println("1- Gerar dados");
        System.out.println("2- Entrar com dados");
        op = scanner.nextInt();

        return op;
    }
    public static int menuComentado() {

        int op;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nComentar algoritimos?");
        System.out.println("1[sim] | 2[não]");
        op = scanner.nextInt();

        return op;
    }
    public static int menuEntradaSorts() {

        Scanner scanner = new Scanner(System.in);

        int op;
        
        System.out.println("\nMenu Metodos de Ordenação");
        System.out.println("1- BubbleSort");
        System.out.println("2- SelectionSort");
        System.out.println("3- InsertionSort");
        System.out.println("4- MergeSort");
        System.out.println("5- QuickSort");
        System.out.println("6- CountingSort");
        System.out.println("7- HeapSort");
        System.out.println("8- SheelSort");
        System.out.println("9- comparar tempos");
        op = scanner.nextInt();

        return op;
    }
    
    public static int menuEntradaSortsComentado() {

        Scanner scanner = new Scanner(System.in);

        int op;
        
        System.out.println("\nMenu Metodos de Ordenação comentados");
        System.out.println("1- BubbleSort - comentado");
        System.out.println("2- SelectionSort - comentado");
        System.out.println("3- InsertionSort - comentado");
        System.out.println("4- MergeSort - comentado");
        System.out.println("5- QuickSort - comentado");
        System.out.println("6- CountingSort - comentado");
        System.out.println("7- HeapSort - comentado");
        System.out.println("8- SheelSort - comentado");
        op = scanner.nextInt();

        return op;
    }

    
}
