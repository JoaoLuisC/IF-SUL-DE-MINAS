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
public class Exercicio015 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String valor = scan.next();
        int tamanho = valor.length();
        
        boolean b = true;
        
        for(int i = 0; i < tamanho; i++){
            if(valor.substring(i, i+1).equals(valor.substring(tamanho-1, tamanho)) != true)
                b = false;
            tamanho--;
        }
        
        if(b)
            System.out.println("É um capicuas!");
        else
            System.out.println("Não é um capicuas!");
    }
}
