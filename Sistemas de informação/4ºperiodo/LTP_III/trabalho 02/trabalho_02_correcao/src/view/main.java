package view;

import model.Tax;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tax IPI = new Tax("IPI","Imposto Prod. Insdustrializado", 8);
		Tax IPI2 = new Tax("IPI","Imposto Prod. Insdustrializado", 8);
		//Tax ICMS = new Tax("ICMS","Imposto Circ. Mercadorias", 7);
		
		System.out.println(IPI == IPI2);
		
		
		
		
	}

}
