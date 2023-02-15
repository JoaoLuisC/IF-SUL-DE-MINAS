/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author tulio
 */
public class Conta {

    String cliente;// atributos ou variáveis de instância
    double saldo;
    double limite;
    ///////
    public void deposita(double saldo){ // método deposita
        this.saldo += saldo;
        System.out.println("Deposito efetuado com sucesso.");
    }
    /////// 
    public void saca(double saque){ // método saque
       if(this.saldo<saque){
           System.out.println("Você não possui saldo suficiente para saque.");
       }else{
           this.saldo -= saque;
            System.out.println("Saque efetuado com sucesso.");
       }  
    }
    ///////
    public void transfere(Conta outraConta,double valor){ // método deposita
        if(this.saldo>valor){
            this.saldo -= valorring cliente;// atributos ou variáveis de instância
    double saldo;
    double limite;
    ///////
    public void deposita(double saldo){ // método deposita
        this.saldo += saldo;
        System.out.println("Deposito efetuado com sucesso.");
    }
    /////// 
    public void saca(double saque){ // método saque
       if(this.saldo<saque){
           System.out.println("Você não possui saldo suficiente para saque.");
       }else{;
            outraConta.saldo += valor;
            System.out.println("Transferencia efetuada com sucesso.");
        }else{
            System.out.println("Saldo insuficiente para transferencia.");
        }
    }
    //////////
    
}
