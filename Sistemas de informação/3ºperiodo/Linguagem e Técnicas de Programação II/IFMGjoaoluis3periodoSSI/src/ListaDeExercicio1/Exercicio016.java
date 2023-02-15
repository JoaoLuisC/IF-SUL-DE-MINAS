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
public class Exercicio016 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String palavra = scan.next();
        
        int qtdLetras = palavra.length();
        
        int cnt = 0, i = 0;
        while( i < qtdLetras){
            if(palavra.substring(i, i+1).equals("a"))
                cnt++;
            i++;
        }
        
        System.out.println("Qtd de 'a': " + cnt);
    }
}
