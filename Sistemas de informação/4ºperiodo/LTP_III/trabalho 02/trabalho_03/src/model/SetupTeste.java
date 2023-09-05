package model;
import java.util.ArrayList;
import java.util.Arrays;

import model.imposto.Imposto;

public class SetupTeste {
	
	public static ArrayList<Imposto> popularImpostos() {
        ArrayList<Imposto> impostos = new ArrayList<>();

        Imposto icms = new Imposto("Confins", 7.0);
        Imposto confins = new Imposto("ICMS", 12.0);
        Imposto ipi = new Imposto("ISS", 8.0);
        Imposto iss = new Imposto("IPI", 5.0);
        Imposto cide = new Imposto("Cide", 10.0);
        Imposto csll = new Imposto("CSLL", 4.0);

        impostos.add(icms);
        impostos.add(confins);
        impostos.add(ipi);
        impostos.add(iss);
        impostos.add(cide);
        impostos.add(csll);

        return impostos;
    }

	public static ArrayList<Produto> popularProdutos(ArrayList<Imposto> impostos) {
		
        ArrayList<Produto> produtos = new ArrayList<>();

        Produto arroz = new Produto(100, "Arroz", 30);
        Produto feijao = new Produto(7.00, "Feijão", 25);
        Produto carne = new Produto(7.00, "Carne", 35);
        Produto cerveja = new Produto(7.00, "Cerveja", 30);
        Produto gas = new Produto(7.00, "Gás", 0.15);
        Produto gasolina = new Produto(7.00, "Gasolina", 15);
        
        
        arroz.setImpostos(new ArrayList<>(Arrays.asList(/*impostos.get(0),*/ impostos.get(1), impostos.get(2)))); // Confins, ICMS e ISS
        feijao.setImpostos(new ArrayList<>(Arrays.asList(impostos.get(0), impostos.get(1), impostos.get(2)))); // Confins, ICMS e ISS
        carne.setImpostos(new ArrayList<>(Arrays.asList(impostos.get(0), impostos.get(1), impostos.get(3)))); // Confins, ICMS e IPI
        cerveja.setImpostos(new ArrayList<>(Arrays.asList(impostos.get(0), impostos.get(1), impostos.get(2), impostos.get(3)))); // Confins, ICMS, ISS e IPI
        gas.setImpostos(new ArrayList<>(Arrays.asList(impostos.get(0), impostos.get(1), impostos.get(3)))); // Confins, ICMS e IPI
        gasolina.setImpostos(new ArrayList<>(Arrays.asList(impostos.get(0), impostos.get(1), impostos.get(4)))); // ICMS, Confins e CSLL

        
        
        produtos.add(gasolina);
        produtos.add(arroz);
        produtos.add(feijao);
        produtos.add(carne);
        produtos.add(cerveja);
        produtos.add(gas);
        
        return produtos;

	}
	
	
}
