package javasorts;

public class SsortParaCaracteres {
    public static long comparacao = 0, troca = 0;

    private static int indexMinArray(char[] array, int posAtual) {
        char minChar = array[posAtual];
        int minIndex = posAtual;

        for (int i = posAtual + 1; i < array.length; i++) {
            comparacao++; // Conta as comparações
            if (array[i] < minChar) {
                minChar = array[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void sSort(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int k = indexMinArray(array, i);

            // Trocar valores de i com k
            troca++; // Conta as trocas
            char temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }
    }

    public static void main(String[] args) {
        char[] charArray = {'c', 'b', 'a', 'f', 'e', 'd'};

        // Ordenar o vetor de caracteres
        sSort(charArray);

        // Imprimir o vetor de caracteres ordenado
        for (char c : charArray) {
            System.out.print(c + " ");
        }

        // Imprimir estatísticas de comparações e trocas
        System.out.println("\nComparacoes: " + comparacao);
        System.out.println("Trocas: " + troca);
    }
}
