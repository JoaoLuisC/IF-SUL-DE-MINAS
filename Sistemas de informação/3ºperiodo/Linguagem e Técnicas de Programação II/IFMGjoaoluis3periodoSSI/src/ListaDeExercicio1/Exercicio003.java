/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDeExercicio1;

/**
 *
 * @author joaol
 */
public class Exercicio003 {
    //Imprima todos os múltiplos de 5, entre 1 e 100.
    public static void main(String[] args) {
        
        for (int i = 0; i <= 100; i++) {
            if (i % 5 == 0) {
                System.out.println(i + " é divisível por 5");
            }
        }

    }
}
