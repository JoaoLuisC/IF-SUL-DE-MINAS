
package javaBusca;

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
}
