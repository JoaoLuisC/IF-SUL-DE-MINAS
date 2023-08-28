package javaBusca;

public class BuscaLinear {
    public static boolean LinearSearch(int[] array, int x){
       
        for(int i = 0;i<array.length;i++){
            if(x==array[i])
                return true;
        }
        
        return false;
    }
    
    public static boolean LinearSearchComentado(int[] array, int x){
       
        int comparacoes = 0;
        
        for(int i = 0;i<array.length;i++){
            if(x==array[i]){
                comparacoes++;
                return true;
            }
                
            comparacoes++;
        }
        
        System.out.println("numero de comparações: " + comparacoes );
        
        return false;
    }
}
