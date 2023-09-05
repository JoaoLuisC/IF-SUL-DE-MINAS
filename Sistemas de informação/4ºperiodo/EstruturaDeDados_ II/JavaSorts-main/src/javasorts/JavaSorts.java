package javasorts;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JavaSorts {

    public static void printArray(int array[]) {
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "| ");
        }

        System.out.println("\n");
    }// fim printArray

    
    public static void main(String[] args) throws IOException, InterruptedException  {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int tamanho, op = 0,op2 =0;

        System.out.println("Tamanho do vetor:");
        tamanho = scanner.nextInt();
        int[] vetorPrincipal = new int[tamanho];
        int[] vetorAux = new int[vetorPrincipal.length]; 

        op = Menus.menuEntrada(op);

        switch (op) {

            case 1:
                for (int i = 0; i < vetorPrincipal.length; i++) {
                    vetorPrincipal[i] = rand.nextInt(1000);
                }
                break;

            case 2:
                System.out.println("Dados vetor:");
                for (int i = 0; i < vetorPrincipal.length; i++) {
                    vetorPrincipal[i] = scanner.nextInt();
                }
                break;

        }
        
        int[] vetorParaComparacao  = Arrays.copyOf(vetorPrincipal, vetorPrincipal.length);
        
        
        op2 = Menus.menuComentado();
        
        if(op2==1){
            op = Menus.menuEntradaSorts();
        
        
            switch (op) {

                //BubbleSort
                case 1:
                    long tempoInicialBsort = System.nanoTime();         

    //              BubbleSort.bSortComentado(vetor);
                    BubbleSort.bSort(vetorPrincipal);

                    long tempoFinalBsort = System.nanoTime();
                    long tempoExecucaoNanosBsort = tempoFinalBsort - tempoInicialBsort;
                    double tempoExecucaoSegundosBsort= tempoExecucaoNanosBsort / 1e9; // Convertendo para segundos

                    System.out.println("\nTempo de execução: " + tempoExecucaoSegundosBsort + " segundos\n");
                  //System.out.println("Comparações: "+BubbleSort.comparacao+" trocas:"+BubbleSort.troca);

                break;

                //SelectionSort
                case 2:
                    long tempoInicialSelectSort = System.nanoTime();               

     //             SelectionSort.sSortComentado(vetor);                
                    SelectionSort.sSort(vetorPrincipal);


                    long tempoFinalSelectSort = System.nanoTime();
                    long tempoExecucaoNanosSelectSort = tempoFinalSelectSort - tempoInicialSelectSort;
                    double tempoExecucaoSegundosSelectSort = tempoExecucaoNanosSelectSort / 1e9; // Convertendo para segundos

                    System.out.println("\nTempo de execução: " + tempoExecucaoSegundosSelectSort + " segundos\n");
                  //System.out.println("Comparações: "+SelectionSort.comparacao+" troca: "+SelectionSort.troca);
                break;

                //InsertionSort
                case 3: 
                    long tempoInicialInsertSort = System.nanoTime();

                    InsertionSort.iSort(vetorPrincipal);               

                    long tempoFinalInsertSort = System.nanoTime();
                    long tempoExecucaoNanosInsertSort = tempoFinalInsertSort - tempoInicialInsertSort;
                    double tempoExecucaoSegundosInsertSort = tempoExecucaoNanosInsertSort / 1e9; // Convertendo para segundos

                    System.out.println("\nTempo de execução: " + tempoExecucaoSegundosInsertSort + " segundos\n");
                  //System.out.println("Comparações: "+InsertionSort.comparacao+"deslocamento:"+InsertionSort.deslocamento);
                break;

                //MergeSort
                case 4:
                    long tempoInicialMergeSort = System.nanoTime();   

                    MergeSort.mergeSort(vetorPrincipal, vetorAux, 0, vetorPrincipal.length-1);

                    long tempoFinalMergeSort = System.nanoTime();
                    long tempoExecucaoNanosMergeSort = tempoFinalMergeSort - tempoInicialMergeSort;
                    double tempoExecucaoSegundosMergeSort = tempoExecucaoNanosMergeSort / 1e9; // Convertendo para segundos

                    System.out.println("\nTempo de execução: " + tempoExecucaoSegundosMergeSort + " segundos\n");
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
                //comparar tempos
                case 9:


                break;

            }
        }else{
            op = Menus.menuEntradaSortsComentado();
        
        
            switch (op) {

                //BubbleSort
                case 1:
                         

                    BubbleSort.bSortComentado(vetor);

                    System.out.println("\nTempo de execução: " + tempoExecucaoSegundosBsort + " segundos\n");
                    //System.out.println("Comparações: "+BubbleSort.comparacao+" trocas:"+BubbleSort.troca);

                break;

                //SelectionSort
                case 2:
                    long tempoInicialSelectSort = System.nanoTime();               

     //             SelectionSort.sSortComentado(vetor);                
                    SelectionSort.sSort(vetorPrincipal);


                    long tempoFinalSelectSort = System.nanoTime();
                    long tempoExecucaoNanosSelectSort = tempoFinalSelectSort - tempoInicialSelectSort;
                    double tempoExecucaoSegundosSelectSort = tempoExecucaoNanosSelectSort / 1e9; // Convertendo para segundos

                    System.out.println("\nTempo de execução: " + tempoExecucaoSegundosSelectSort + " segundos\n");
                  //System.out.println("Comparações: "+SelectionSort.comparacao+" troca: "+SelectionSort.troca);
                break;

                //InsertionSort
                case 3: 
                    long tempoInicialInsertSort = System.nanoTime();

                    InsertionSort.iSort(vetorPrincipal);               

                    long tempoFinalInsertSort = System.nanoTime();
                    long tempoExecucaoNanosInsertSort = tempoFinalInsertSort - tempoInicialInsertSort;
                    double tempoExecucaoSegundosInsertSort = tempoExecucaoNanosInsertSort / 1e9; // Convertendo para segundos

                    System.out.println("\nTempo de execução: " + tempoExecucaoSegundosInsertSort + " segundos\n");
                  //System.out.println("Comparações: "+InsertionSort.comparacao+"deslocamento:"+InsertionSort.deslocamento);
                break;

                //MergeSort
                case 4:
                    long tempoInicialMergeSort = System.nanoTime();   

                    MergeSort.mergeSort(vetorPrincipal, vetorAux, 0, vetorPrincipal.length-1);

                    long tempoFinalMergeSort = System.nanoTime();
                    long tempoExecucaoNanosMergeSort = tempoFinalMergeSort - tempoInicialMergeSort;
                    double tempoExecucaoSegundosMergeSort = tempoExecucaoNanosMergeSort / 1e9; // Convertendo para segundos

                    System.out.println("\nTempo de execução: " + tempoExecucaoSegundosMergeSort + " segundos\n");
                  //System.out.println("Comparações: trocas:");
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
                //comparar tempos
                case 9:


                break;

            }
        }
        
        
        
        //System.out.println("\nVetor original:");
        //printArray(vetorOriginal);
        //System.out.println("Vetor ordenado");
        //printArray(vetor);
        //clearConsole();
    }

}
