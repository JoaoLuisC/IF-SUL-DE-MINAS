package javaBusca;

public class BuscaLinear {
    public static boolean LinearSearch(int[] array, int x){
       
        for(int i = 0;i<array.length;i++){
            if(x==array[i])
                return true;
        }
        
        return false;
    }
}
