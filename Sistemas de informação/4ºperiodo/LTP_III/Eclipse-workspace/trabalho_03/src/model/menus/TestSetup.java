package model.menus;
import java.util.ArrayList;
import java.util.Arrays;

import model.products.Products;
import model.taxes.Taxes;

public class TestSetup{
	
	public static ArrayList<Taxes> popularImpostos() throws Exception {
        ArrayList<Taxes> impostos = new ArrayList<>();

        Taxes icms = new Taxes("Confins","Imposto sobre Circulação de Mercadorias e Serviços", 7.0);
        Taxes confins = new Taxes("ICMS","Contribuição para o Financiamento da Seguridade Social", 12.0);
        Taxes ipi = new Taxes("ISS","Contribuição para o Financiamento da Seguridade Social", 8.0);
        Taxes iss = new Taxes("IPI","Imposto sobre Serviços de Qualquer Natureza", 5.0);
        Taxes cide = new Taxes("Cide","Contribuição de Intervenção no Domínio Econômico", 10.0);
        Taxes csll = new Taxes("CSLL","Contribuição Social sobre o Lucro Líquido", 4.0);

        impostos.add(icms);
        impostos.add(confins);
        impostos.add(ipi);
        impostos.add(iss);
        impostos.add(cide);
        impostos.add(csll);

        return impostos;
    }

	public static ArrayList<Products> popularProdutos(ArrayList<Taxes> impostos) throws Exception {
		
        ArrayList<Products> produtos = new ArrayList<>();

      
        Products arroz = new Products(100, "Arroz", 30, new ArrayList<>
        (Arrays.asList(/*impostos.get(0),*/ impostos.get(1), impostos.get(2)))); // Confins, ICMS e ISS
        
        Products feijao = new Products(7.00, "Feijão", 25, new ArrayList<>
        (Arrays.asList(impostos.get(0), impostos.get(1), impostos.get(2)))); // Confins, ICMS e ISS
        
        Products carne = new Products(7.00, "Carne", 35, new ArrayList<>
        (Arrays.asList(impostos.get(0), impostos.get(1), impostos.get(3)))); // Confins, ICMS e IPI
        
        Products cerveja = new Products(7.00, "Cerveja", 30, new ArrayList<>
        (Arrays.asList(impostos.get(0), impostos.get(1), impostos.get(2), impostos.get(3)))); // Confins, ICMS, ISS e IPI
       
        Products gas = new Products(7.00, "Gás", 0.15, new ArrayList<>
        (Arrays.asList(impostos.get(0), impostos.get(1), impostos.get(3)))); // Confins, ICMS e IPI
        
        Products gasolina = new Products(7.00, "Gasolina", 15, new ArrayList<>
        (Arrays.asList(impostos.get(0), impostos.get(1), impostos.get(4)))); // ICMS, Confins e CSLL

        
        
        produtos.add(gasolina);
        produtos.add(arroz);
        produtos.add(feijao);
        produtos.add(carne);
        produtos.add(cerveja);
        produtos.add(gas);
        
        return produtos;

	}
	
	
}
