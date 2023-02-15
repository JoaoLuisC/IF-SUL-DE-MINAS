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
public class Exercicio008 {
    /*
    Uma parede em formato retangular, cuja altura é HP (altura da parede) e largura é LP
    (largura da parede) precisa ser coberta por azulejos também regulares. O azulejo retangular
    tem dimensões HA(altura do azulejo) e LA (largura do azulejo). Escreva um programa que leia
    as quatro medidas HP, LP, HA e LA, calcule e imprima quantos azulejos com as medidas
    dadas são necessários para cobrir a parede dada.
    */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a Largura da Parede:");
        double LP = sc.nextDouble();
        System.out.println("Digite a Altura da Parede:");
        double HP = sc.nextDouble();
        System.out.println("Digite a Largura do Azuleijo:");
        double LA = sc.nextDouble();
        System.out.println("Digite a Altura do Azuleijo:");
        double HA = sc.nextDouble();
        
        double areaP;
        areaP = LP*HP;
        
        double areaA;
        areaA = LA*HA;
        
        double qtdA;
        qtdA = areaP/areaA;
        
        System.out.println("A quantidade de azuleijos necessarios para preencher "
                + "uma parede de "+areaP+" metros é de "+qtdA+" azuleijos.");
        
        
        sc.close();
    }
}
