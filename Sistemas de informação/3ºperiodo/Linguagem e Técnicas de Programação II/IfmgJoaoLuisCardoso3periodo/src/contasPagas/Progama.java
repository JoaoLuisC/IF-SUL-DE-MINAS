/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contasPagas;

/**
 *
 * @author joaol
 */
public class Progama {
    
    public static void main(String[] args) {
        Produto prod1 = new Produto();
        Produto prod2 = new Produto();

        Cliente cli1 = new Cliente();
        Cliente cli2 = new Cliente();

        Conta conta1 = new Conta();
        Conta conta2 = new Conta();        
        
        prod1.setDescricaoProduto("Iphone 12 mini");
        prod1.setValorProduto(2500);
        prod2.setDescricaoProduto("Mouse razer");
        prod2.setValorProduto(1800);
        
        cli1.setNomeCliente("Davi");
        cli1.setCpf("123.456.789-00");
        cli2.setNomeCliente("Lucas");
        cli2.setCpf("123.456.789-00");
        
        conta1.setIdConta(1);
        conta1.setDataVencimento("04/06/2023");
        conta1.setDataPagamento("01/04/2023");
        conta1.cli = cli1;
        conta1.pro = prod1;

        
        conta2.setIdConta(2);
        conta2.setDataVencimento("5/05/2023");
        conta2.setDataPagamento("20/01/2023");
        conta2.cli = cli2;
        conta2.pro = prod2;

        
        conta1.vizualizarConta();
        conta2.vizualizarConta();
        
    }
   
    
    
    
    
}
