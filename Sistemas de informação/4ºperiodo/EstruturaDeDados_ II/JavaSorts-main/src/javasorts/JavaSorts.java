package javasorts;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JavaSorts {

    static int menuEntrada() {

        Scanner scanner = new Scanner(System.in);

        int op;
        
        System.out.println("\nMenu Gerenciador de dados");
        System.out.println("1- Gerar dados");
        System.out.println("2- Entrar com dados");
        op = scanner.nextInt();

        return op;
    }

    static int menuEntradaSorts() {

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
        op = scanner.nextInt();

        return op;
    }

    public static void printArray(int array[]) {
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "| ");
        }

        System.out.println("\n");
    }// fim printArray
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int tamanho, op;

        System.out.println("Tamanho do vetor:");
        tamanho = scanner.nextInt();
        int[] vetor = new int[tamanho];
        int[] vetorAux = new int[vetor.length]; 

        op = menuEntrada();

        switch (op) {

            case 1:
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = rand.nextInt(100);
                }
                break;

            case 2:
                System.out.println("Dados vetor:");
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = scanner.nextInt();
                }
                break;

        }
        
        int[] vetorOriginal  = Arrays.copyOf(vetor, vetor.length);
        
        op = menuEntradaSorts();
        
        long tempoInicial = System.nanoTime();
        switch (op) {
            
            //BubbleSort
            case 1:
                
//              BubbleSort.bSortComentado(vetor);
                BubbleSort.bSort(vetor);
                
            break;
            
            //SelectionSort
            case 2:
                
                SelectionSort.sSort(vetor);
 //             SelectionSort.sSortComentado(vetor);
                
            break;
            
            //InsertionSort
            case 3:
                
                InsertionSort.iSort(vetor);

            break;
            
            //MergeSort
            case 4:
                   
                MergeSort.mergeSort(vetor, vetorAux, 0, vetor.length-1);
                
            break;
            
            //QuickSort
            case 5:
                

            break;
            
            //CountingSort
            case 6:
                
                
            break;
                        
            //HeapSort
            case 7:
                
            break;
                        
            //SheelSort
            case 8:
                

            break;

        }
        
        long tempoFinal = System.nanoTime();
        long tempoExecucaoNanos = tempoFinal - tempoInicial;
        double tempoExecucaoSegundos = tempoExecucaoNanos / 1e9; // Convertendo para segundos
        System.out.println("\nTempo de execução: " + tempoExecucaoSegundos + " segundos\n");
        
        System.out.println("\nVetor original:");
        printArray(vetorOriginal);
        System.out.println("Vetor ordenado");
        printArray(vetor);

    }

}
