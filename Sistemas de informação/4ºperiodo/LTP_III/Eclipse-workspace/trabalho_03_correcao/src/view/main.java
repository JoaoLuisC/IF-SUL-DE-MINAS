package view;

import model.ICMS;
import model.IPI;
import model.Product;
import model.Tax;

public class main {

public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Product arroz = new Product("Arroz pileco", 100, 30);
		arroz.setIndustrial(true);
		arroz.setIsForeing(false);
		
		Tax ipi = new IPI();
		Tax icms = new ICMS();
		arroz.addTax(icms);
		arroz.addTax(ipi);
		
		System.out.println(arroz.getName()+ "R$: "+arroz.calculateSalePrice());
		
		Product estratoTomate = new Product("Estrato Heinz", 100 , 20);
		estratoTomate.setIndustrial(true);
		estratoTomate.setIsForeing(true);
		
		Tax ipiTomate = new IPI();
		estratoTomate.addTax(ipiTomate);
		
		
		System.out.println(estratoTomate.getName()+ "R$: "+estratoTomate.calculateSalePrice());
		
		
		
	}

}
