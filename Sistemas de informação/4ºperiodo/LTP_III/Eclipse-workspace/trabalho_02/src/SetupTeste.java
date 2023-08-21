import java.util.ArrayList;

public class SetupTeste {
	
	public static ArrayList<Imposto> popularImpostos() {
        ArrayList<Imposto> impostos = new ArrayList<>();

        Imposto icms = new Imposto("ICMS", 7.0);
        Imposto confins = new Imposto("Confins", 12.0);
        Imposto ipi = new Imposto("IPI", 8.0);
        Imposto iss = new Imposto("ISS", 5.0);
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

	public static ArrayList<Produto> popularProdutos() {
		
        ArrayList<Produto> produtos = new ArrayList<>();

        Produto arroz = new Produto(7.00, "Arroz", 0.20);
        Produto feijao = new Produto(7.00, "Feijão", 0.25);
        Produto carne = new Produto(7.00, "Carne", 0.35);
        Produto cerveja = new Produto(7.00, "Cerveja", 0.30);
        Produto gas = new Produto(7.00, "Gás", 0.15);
        Produto gasolina = new Produto(7.00, "Gasolina", 0.15);
        
        produtos.add(gasolina);
        produtos.add(arroz);
        produtos.add(feijao);
        produtos.add(carne);
        produtos.add(cerveja);
        produtos.add(gas);
        
        return produtos;

	}
	
	
}
