package model;

import java.util.ArrayList;

public class DataBaseProducts {
	
	public static ArrayList<Product> dataBaseProduct() {
        ArrayList<Product> listProducts = new ArrayList<>();

        Product arroz = new Product("Arroz pileco T1", 15);
    	Product feijao = new Product("Feijão Malicia", 20);

    	listProducts.add(feijao);
    	listProducts.add(arroz);

        return listProducts;
    }
	
	
	
	

}
