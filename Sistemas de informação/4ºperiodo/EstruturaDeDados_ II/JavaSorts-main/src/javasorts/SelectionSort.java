package javasorts;

import java.util.Scanner;

public class SelectionSort {
    
    public static long comparacao = 0 ,troca = 0;
    
    private static int indexMinArray(int array [],int posAtual){   //menor valor do Array
       
        int K = posAtual; //variavel de menor posição 
            
        //loop para percorrer o array e achar o menor valor
        for(int i = posAtual; i<array.length; i++){
            comparacao++;//conta as comparações
            if(array[i] < array[K])//se o array na posição atual for menor q a posição atual ele altera a 
                 K = i;            //variavel K para o novo menor   
        }
      
        return K;
    } 
    
    
    public static int sSort(int array[]){
        
        for(int i = 0; i < array.length-1;i++){
            int k = indexMinArray(array, i);
            
            //trocar valores de i com k
            troca++;//conta as trocas
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
            
        }
        
        
        return 0;
    }
    
     public static int sSortComentado(int array[]){
        
        Scanner scanner = new Scanner(System.in);
         
        for(int i = 0; i < array.length-1;i++){
            int k = indexMinArray(array, i);
            
            System.out.println("Atual: "+array[i] + " Trocando com o menor valor: " + array[k]);
            scanner.nextLine();//pausa
            //trocar valores de i com k
            
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
            
        }
        
        
        return 0;
    }
    

}
