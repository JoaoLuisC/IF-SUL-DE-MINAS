/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDeExercicio1;

import java.util.Scanner;

/**
 *
 * @author joaol
 */
public class Exercicio017 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int valor = scan.nextInt();
        String letra = scan.next();
        
        for(int i = 0; i < valor; i++)
            System.out.printf(letra);
        
        System.out.println("");
    }
}
