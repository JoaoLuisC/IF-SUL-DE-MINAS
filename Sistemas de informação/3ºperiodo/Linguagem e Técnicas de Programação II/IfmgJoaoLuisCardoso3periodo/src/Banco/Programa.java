package banco;

import java.util.Scanner;


public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Conta minhaConta = new Conta();
        Conta outraConta = new Conta();
        
        System.out.println("Digite um valor para depósito:");
        minhaConta.deposita(sc.nextDouble());
        
        System.out.println("Digite um valor para sacar:");
        minhaConta.saca(sc.nextDouble());
        
        System.out.println("Digite um valor para transferencia:");
        minhaConta.transfere( outraConta, sc.nextDouble());
        
        
       sc.close();
    }
    
}
