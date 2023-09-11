package model.menus;

import java.util.ArrayList;
import java.util.Arrays;

import model.products.Products;
import model.taxes.Taxes;

public class TestSetup {

	public static ArrayList<Taxes> popularImpostos() throws Exception {
		ArrayList<Taxes> impostos = new ArrayList<>();

		Taxes icms = new Taxes("ICMS","Imposto sobre Circulação de Mercadorias e Serviços", 5.0);
        //Taxes cofins = new Taxes("COFINS","Contribuição para o Financiamento da Seguridade Social", 12.0);
        Taxes ipi = new Taxes("IPI","Imposto sobre Serviços de Qualquer Natureza", 8.0);
        Taxes iss = new Taxes("ISS","Imposto sobre Serviços de Qualquer Natureza", 5.0);
        //Taxes cide = new Taxes("CIDE","Contribuição de Intervenção no Domínio Econômico", 10.0);
        //Taxes csll = new Taxes("CSLL","Contribuição Social sobre o Lucro Líquido", 4.0);

		impostos.add(icms);
		//impostos.add(cofins);
		impostos.add(ipi);
		impostos.add(iss);
		//impostos.add(cide);
		//impostos.add(csll);

		return impostos;
	}

	public static ArrayList<Products> popularProdutos(ArrayList<Taxes> impostos) throws Exception {

		ArrayList<Products> produtos = new ArrayList<>();
		
		// Produto "Arroz"
		Products arroz = new Products(7, "Arroz", 30, false); 
		arroz.setTaxes(new ArrayList<>(Arrays.asList(impostos.get(0), impostos.get(2))));// ICMSe ISS

		// Produto "Feijão"
		Products feijao = new Products(7.00, "Feijão", 25, false);
		feijao.setTaxes(new ArrayList<>(Arrays.asList(impostos.get(0), impostos.get(2)))); // ICMS e ISS

		// Produto "Carne"
		Products carne = new Products(7.00, "Carne", 35, true);
		carne.setTaxes(new ArrayList<>(Arrays.asList(impostos.get(0), impostos.get(1)))); // ICMS e IPI

		// Produto "Cerveja"
		Products cerveja = new Products(7.00, "Cerveja", 30, true);
		cerveja.setTaxes(new ArrayList<>(Arrays.asList(impostos.get(0), impostos.get(1), impostos.get(2)))); // ICMS, ISS e IPI

		// Produto "Gás"
		Products gas = new Products(7.00, "Gás", 15, false);
		gas.setTaxes(new ArrayList<>(Arrays.asList(impostos.get(0), impostos.get(1)))); // ICMS e IPI

		// Produto "Gasolina"
		Products gasolina = new Products(7.00, "Gasolina", 15, true);
		gasolina.setTaxes(new ArrayList<>(Arrays.asList(impostos.get(0)))); // ICMS


		
		produtos.add(arroz);
		produtos.add(feijao);
		produtos.add(carne);
		produtos.add(cerveja);
		produtos.add(gas);
		produtos.add(gasolina);
		
		return produtos;

	}

}
