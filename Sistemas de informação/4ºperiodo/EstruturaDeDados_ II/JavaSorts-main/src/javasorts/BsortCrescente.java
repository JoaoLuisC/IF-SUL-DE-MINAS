
package javasorts;

public class BsortCrescente {
    public static long comparacao = 0, troca = 0;

    public static void bSort(int array[]) {
        for (int fase = 1; fase < array.length; fase++) {
            for (int comp = 0; comp < array.length - fase; comp++) {
                comparacao++; // contando comparações
                if (array[comp] < array[comp + 1]) { // Mudança para ordem decrescente
                    troca++; // contando trocas
                    int temp = array[comp];
                    array[comp] = array[comp + 1];
                    array[comp + 1] = temp;
                }
            }
        }
    }
}
