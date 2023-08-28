package javaBusca;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javasorts.InsertionSort;
import javasorts.MergeSort;


public class javaBuscas {
        
    
    public int op;

    static int menuEntrada() {

        Scanner scanner = new Scanner(System.in);

        int op;
        
        System.out.println("\nMenu Gerenciador de dados");
        System.out.println("1- Gerar dados");
        System.out.println("2- Entrar com dados");
        op = scanner.nextInt();

        return op;
    }
    
    static int menuEntradaBuscas() {

        Scanner scanner = new Scanner(System.in);

        int op;
        
        System.out.println("\nMenu Metodos de Ordenação");
        System.out.println("1- Linear");
        System.out.println("2- Binario");
        op = scanner.nextInt();

        return op;
    }
    
    public static void printIntervalo (int array[],int ini,int fim) {
        
        for (int i = ini; i <=fim ; i++) {
            System.out.print(array[i] + "| ");
        }

        System.out.println("\n");
    }// fim printArray
    
    public static void main(String[] args) throws IOException, InterruptedException  {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int tamanho, op,op2;

        System.out.println("Tamanho do vetor:");
        tamanho = scanner.nextInt();
        int[] vetorPrincipal = new int[tamanho];
        int[] vetorAux = new int[vetorPrincipal.length]; 

        op = menuEntrada();

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
   
        System.out.println("Numero para procurar:");
        int procura = scanner.nextInt();
        op2 = menuEntradaBuscas();
        switch (op2) {
            
            //LinearSeach
            case 1:
                
//                if(BuscaLinear.LinearSearch(vetorPrincipal, procura)== true){
//                   System.out.println("Numero Encontrado.");
//               }else
//                   System.out.println("Numero Não Encontrado.");
                
                if(BuscaLinear.LinearSearchComentado(vetorPrincipal, procura) == true){
                   System.out.println("Numero Encontrado.");
               }else
                   System.out.println("Numero Não Encontrado.");
                
                
                
            break;
            
            //SelectionSort
            case 2:
                
               MergeSort.mergeSort(vetorPrincipal, vetorAux, 0, vetorPrincipal.length-1); 
                
//               if( buscaBinaria.binarySearch(vetorPrincipal, procura) == true){
//                    System.out.println("Numero Encontrado.");
//                }else
//                    System.out.println("Numero Não Encontrado.");
                
               if(buscaBinaria.binarySearchComentado(vetorPrincipal, procura) == true){
                    System.out.println("Numero Encontrado.");
               }else
                   System.out.println("Numero Não Encontrado.");
                
            break;
            
            
            case 3: 
               
            break;
            
           
            case 4:
                
            break;
            
            case 5:
                

            break;
            
            
            case 6:
                
                
            break;
                        
            
            case 7:
                
            break;
                        
            
            case 8:
                

            break;
            
            case 9:
                

            break;

        }
        

    }

}
    

