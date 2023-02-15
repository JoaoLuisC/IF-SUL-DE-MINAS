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
public class Exercicio013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero de pessoas que compram o pacote de turismo: ");
        int numP = sc.nextInt();
        System.out.println("Quantidade de dias do pacote de turismo: ");
        int numD = sc.nextInt();
        float totalP = 0;
        
        if(numP>=1 && numP<=4){
            totalP = numP*160*numD ;
        }else if(numP>=5 && numP<=8){
            totalP = numP*120*numD ;
        }else if(numP>8){
            totalP = numP*80*numD ;
        }
        
        System.out.println("O total a pagar pelo pacote de viagens é de:" + totalP);
        
        
        sc.close();
    }
}
