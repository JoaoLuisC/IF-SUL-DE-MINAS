package model.menus;
import java.util.ArrayList;
import java.util.Arrays;

import model.products.Products;
import model.taxes.Taxes;
import model.taxes.types.Cide;
import model.taxes.types.Cofins;
import model.taxes.types.Csll;
import model.taxes.types.Icms;
import model.taxes.types.Ipi;
import model.taxes.types.Iss;

public class TestSetup{
	
	public static ArrayList<Taxes> popularImpostos() throws Exception {
        ArrayList<Taxes> impostos = new ArrayList<>();

        Icms icms = new Icms();
        icms.valuesIcms();

        Cofins confins = new Cofins();
        confins.valuesCofins();

        Ipi ipi = new Ipi();
        ipi.valuesIpi();

        Iss iss = new Iss();
        iss.valuesIss();

        Cide cide = new Cide();
        cide.valuesCide();

        Csll csll = new Csll();
        csll.valuesCsll();

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
