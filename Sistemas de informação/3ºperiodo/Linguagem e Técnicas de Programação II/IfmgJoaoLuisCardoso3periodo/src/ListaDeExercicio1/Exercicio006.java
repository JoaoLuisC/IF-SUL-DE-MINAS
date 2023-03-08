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
public class Exercicio006 {
    /*
    Faça um programa que, a partir da leitura das medidas dos lados de um retângulo
    (comprimento e largura), lidos do teclado, calcule e imprima a área e o perímetro do retângulo.
    */
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o comprimento do retangulo: ");
        float comprimento = sc.nextFloat();
        System.out.println("Digite o comprimento do retangulo: ");
        float largura = sc.nextFloat();
        
        
        float area;
        area=comprimento*largura;
        float perimetro;
        perimetro = (comprimento+largura)*2;
        
        System.out.println("O perimetro é de: "+perimetro+".");
        System.out.println("A area é de: "+area+".");
        
        
        sc.close();
    }
    
    
}
