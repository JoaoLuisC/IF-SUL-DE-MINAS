package view;

import model.Product;
import model.Tax;

public class main {

public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Product arroz = new Product("Arroz pileco", 100, 30);
		
		Tax IPI = new Tax("IPI","Imposto Prod. Insdustrializado", 8);
		Tax ISS = new Tax("ISS","ISS teste", 12);
		Tax ICMS = new Tax("ICMS","Imposto Circ. Mercadorias", 10);
		
		arroz.addTax(IPI);
		arroz.addTax(ISS);
		arroz.addTax(ICMS);
		
		System.out.println(arroz.getName()+ "R$: "+arroz.calculateSalePrice());
		
		
		
	}

}
