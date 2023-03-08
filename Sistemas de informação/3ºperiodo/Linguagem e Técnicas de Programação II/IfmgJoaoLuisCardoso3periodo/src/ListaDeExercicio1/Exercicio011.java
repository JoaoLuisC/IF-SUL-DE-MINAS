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
public class Exercicio011 {
    /*
    
    Uma empresa de locação de veículos cobra pelo uso de seus veículos populares a partir
    da seguinte regra:
     45.00 reais para cada dia de uso como custo fixo;
     0.50 centavos de real para cada quilômetro que exceder o total de quilômetros dados
    de cortesia.
     A cada dia o usuário tem direito a 60 quilômetros de cortesia
     O usuário efetua o pagamento somente ao devolver o carro à empresa de locação.
    Escreva um programa que leia o número de dias que o usuário ficou com o carro e a
    quilometragem do mesmo e imprima o valor a ser pago.
    
    */
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade de dias que o caroo ficou locado"
                + " e a quantidade de km rodados respectivamente");
        double qtdDias = sc.nextDouble();
        double qtdKms = sc.nextDouble();
        double total=0;
        double kmsM;
        
        kmsM = qtdKms-(qtdDias*60);
        
        if(kmsM==0){
            total = qtdDias*45;
        }else{
            total = (qtdDias*45)+(kmsM*0.5);
        }      
       
        System.out.println("A quantidade a ser paga é de: "+ total);
  
        sc.close();
    }
}
