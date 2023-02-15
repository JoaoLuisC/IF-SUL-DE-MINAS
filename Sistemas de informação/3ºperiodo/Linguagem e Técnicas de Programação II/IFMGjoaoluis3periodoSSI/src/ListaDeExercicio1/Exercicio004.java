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
public class Exercicio004 {
    //Faca um programa que leia pelo teclado um valor, em dolar, converta e imprima o mesmo
    //num valor em reais. Considere que $ 1.00 dolar seja equivalente a R$5.10 
   
    public static void main(String[] args) {
        
        float real;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um valor em dolares: ");
        float dolar = scanner.nextFloat();
        
        real = dolar * 5.10f;   
        
        System.out.println("A convercao de $"+dolar+" Dolares para Real é de R$"+real+" reais.");
        scanner.close();
    }
        
}

