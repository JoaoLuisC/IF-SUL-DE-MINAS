package model;

import java.util.HashMap;
import java.util.Map;

public class DataBaseProducts {
	
	private static Map<String ,String []> products = new HashMap();
	
	static {
		products.put("arroz", new String[]{"Arroz tipo 1" , "20"});
		products.put("feijao", new String[]{"Feijão Malicia" , "30"});
		products.put("sal", new String[]{"Sal rosa" , "8"});

	}
	
	public static String[] getProductDescription (String key) {
		return products.get(key);
	}

}
