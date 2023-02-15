/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDeExercicio1;
import java.text.DecimalFormat;
import java.util.Scanner;
/**
 *
 * @author joaol
 */
public class Exercicio005 {
   /*
    A condição física de uma pessoa pode ser medida com base no cálculo do índice de Massa
    Corporal (IMC). Faça um programa que calcule o IMC com base nos dados abaixo:
    IMC = PESO /(ALTURA)2
    */ 
    public static void main(String[] args) {
        DecimalFormat frmt = new DecimalFormat();
        frmt.setMaximumFractionDigits(2);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Digite seu peso: ");
            float peso = sc.nextFloat();
            System.out.println("Digite sua altura: ");
            float altura= sc.nextFloat();
            
            System.out.println("Se homem[1], Se Mulher[2]");
            int sexo = sc.nextInt();
            
            float imc;
            imc = peso/(altura*altura);
            
            System.out.println("Com peso: "+peso+", e altura: "+altura+"  Seu IMC é de: "+frmt.format(imc));
            
            if(sexo==1){
                if(imc < 20.7){
                    System.out.println("Abaixo do Peso.");
                }else if(imc>= 20.7 && imc<= 26.4){
                    System.out.println("Peso Ideal.");
                }else{
                    System.out.println("Obeso.");
                }
            }else if(sexo==2){
                if(imc <19.1){
                    System.out.println("Abaixo do Peso.");
                }else if(imc>= 19.1 && imc<= 25.8){
                    System.out.println("Peso Ideal.");
                }else{
                    System.out.println("Obeso.");
                }
            }
        }
    }
    
}
