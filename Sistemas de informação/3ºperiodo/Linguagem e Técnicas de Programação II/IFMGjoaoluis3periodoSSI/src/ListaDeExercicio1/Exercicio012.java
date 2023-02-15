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
public class Exercicio012 {
    /*
    De forma simplificada, o IRPF Simples Anual pode ser calculado a partir das seguintes
    regras, no caso de um contribuinte com anual dada:
     Caso o contribuinte ganhe até 10800.00 reais, ele está isento do pagamento

     Caso o contribuinte ganhe entre 10800.00 até 21600.00 reais, ele deve calcular o seu
    IRPF Simples multiplicando sua renda por 0.15 (alíquota de 15%) e subtraindo da
    multiplicação 1620.00 reais.
     Quando o contribuinte ganhar a partir de 21600.01 reais, ele deve calcular seu IRPF
    Simples multiplicando sua renda por 0.275 (alíquota de 27.5%) e subtrair da
    multiplicação 4320.00 reais.
    Escreva um programa que leia o valor da renda de um contribuinte, imprimindo o IRPF
    Simples a ser pago pelo mesmo.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o valor q o contribuente ganha:");
        double renda = sc.nextDouble();
        double total;
        
        if(renda <= 10800.00 ){
            System.out.println("O contribuente esta isento de pagar o IPRF.");
        }else if(renda > 10800.00 && renda <=21600.00){
            total = (renda*0.15)-1620.00;
           System.out.println("O contribuente deve pagar de IRPF: "+total);
        }else if(renda >21600.00){
            total = (renda*0.275)-4320.00;
           System.out.println("O contribuente deve pagar de IRPF: "+total);
        }
  
        sc.close();
    }
}
