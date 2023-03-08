/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

/**
 *
 * @author joaol
 */
public class TesteFunc {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();
        
        f1.setNome("Marcos");
        f1.setDepartamento("Contabilidade");
        f1.setRg("123.456.789-00");
        f1.setDataAdmissao("01/06/2020");
        f1.setSalario(5440.00);
        
        
        System.out.println("Nome: " + f1.getNome());
        System.out.println("Salario atual: " + f1.getSalario());
        f1.bonifica(249.50);
        System.out.println("Salario Bonificado: " + f1.getSalario());
        
        System.out.println("Status Funcionario 01: " + f1.isAtivo());
        
        System.out.println("Departamento: " + f1.getDepartamento());
        
        f1.trocaDepartamento();
        
        f1.setAtivo(false);
        
        System.out.println("Status Funcionario 01: " + f1.isAtivo());
        
        System.out.println("//teste metodo mostra");
        f1.mostra();
    }
}
