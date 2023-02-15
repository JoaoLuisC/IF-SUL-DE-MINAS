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
public class Exercicio009 {
    /*
    Numa determinada região, o imposto sobre a propriedade é calculado a partir de duas
    informações:
     Área total do terreno (m2)
     Área construída do terreno (m2)
    O imposto é cobrado da seguinte maneira:
     R$ 5.00 para cada metro quadrado construído
     R$ 3.80 para cada metro não construído
    Faça um programa que leia a área total do terreno, a área construída do terreno, calcule e
    imprima o valor total a ser pago.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digete a area total do terreno: ");
        double areaTter = sc.nextDouble();
        System.out.println("Digete a area total construida no terreno: ");
        double areaTconst = sc.nextDouble();
        
        double impConst;
        impConst = areaTconst*5.00;
        double impNconst;
        impNconst = (areaTter-areaTconst)*3.80;
        
        System.out.println("O imposto total a ser pago é de: "+(impConst+impNconst));
        
        sc.close();
    }
    
    
}
