/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDeExercicio1;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author joaol
 */
public class Exercicio007 {
    /*
    Faça um programa para calcular a média final de um aluno a partir de quatro notas
    bimestrais. A média é calculada através de uma média aritmética simples (todos os bimestres
    têm o mesmo peso).
    */
    public static void main(String[] args) {
        
        System.out.println("Digite notas de 0 a 10 com pelo menos duas casas decimais");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a primeira nota: ");
        float nota1 = sc.nextFloat();
        System.out.println("Digite a segunda nota: ");
        float nota2 = sc.nextFloat();
        System.out.println("Digite a terceira nota: ");
        float nota3 = sc.nextFloat();
        System.out.println("Digite a quarta nota: ");
        float nota4 = sc.nextFloat();
        
        float media;
        media = (nota1+nota2+nota3+nota4)/4;
        
        DecimalFormat frmt = new DecimalFormat();
        frmt.setMaximumFractionDigits(2);
        
        System.out.println("A media dos bimestres é de: "+ frmt.format(media));
        
        if(media>0 && media <= 3.49){
            System.out.println("Reprovado");
        }else if(media >=3.5 && media<=6.49){
            System.out.println("Recuperação");
        }else if(media>=6.5){
            System.out.println("Aprovado");
        }
        
        sc.close();
    }
}
