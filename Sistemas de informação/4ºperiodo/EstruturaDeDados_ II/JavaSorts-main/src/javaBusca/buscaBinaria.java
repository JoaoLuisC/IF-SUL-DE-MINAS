
package javaBusca;

import static javaBusca.javaBuscas.printIntervalo;

public class buscaBinaria {
    public static boolean binarySearch (int[] array , int x){
        
        int ini,fim,meio;
        
        ini=0;
        fim = array.length-1;
        
        while(ini<=fim){
            
            meio=(ini+fim)/2;
            
            if(array[meio]>x)
                fim = meio-1;
            else if(array[meio]<x)//se o array[meio] for menor q x, soma o meio +1
                ini = meio+1;
            else//se X for igual o numero do array[meio] retorna true
               return true;
            
        }
        
        return false;
    }
    
    public static boolean binarySearchComentado (int[] array , int x){
        
        int ini,fim,meio;
        
        ini=0;
        fim = array.length-1;
        
        int comparacoes = 0;
        
        while(ini<=fim){
            
            meio=(ini+fim)/2;
            
            System.out.println("Ini:"+ini+" Meio:"+meio+" Fim"+fim);
            javaBuscas.printIntervalo(array, ini, fim);
            
            comparacoes++;
            
            if(array[meio]>x){
                fim = meio-1;
            }else if(array[meio]<x){//se o array[meio] for menor q x, soma o meio +1
                ini = meio+1;
            }else{//se X for igual o numero do array[meio] retorna true
                System.out.println("numero de comparações: " + comparacoes );
               return true; 
            }
            
        }
        
        System.out.println("numero de comparações: " + comparacoes );
        
        return false;
    }
}
