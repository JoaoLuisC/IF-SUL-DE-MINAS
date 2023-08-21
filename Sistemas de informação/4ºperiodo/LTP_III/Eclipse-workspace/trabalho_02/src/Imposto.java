import java.util.ArrayList;
import java.util.Scanner;

public class Imposto {

	private double taxaImposto;
	private String nomeImposto;
	
	//Construtor
	public Imposto() {

    }
	
	public Imposto(String nomeImposto, double taxaImposto) {
		super();
        this.nomeImposto = nomeImposto;
        this.taxaImposto = taxaImposto;
    }

	//GETTERS imposto
	public double getTaxaImposto() {
		return taxaImposto;
	}
	public String getNomeImposto() {
		return nomeImposto;
	}

	//SETTERS imposto
	public void setTaxaImposto(double taxaImposto) {
		this.taxaImposto = taxaImposto;
	}
	public void setNomeImposto(String nomeImposto) {
		this.nomeImposto = nomeImposto;
	}


	public double SomaImpostos(double imposto) {

		double somaImpostos = imposto;

		return somaImpostos;
	}

	public String formatarImposto() {
		return String.format(" %s %.0f%%"
							,nomeImposto,taxaImposto);
	}

	public static ArrayList<Imposto> insereImposto(ArrayList<Imposto> impostos){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		Imposto imposto = new Imposto();
		
		System.out.println("Digite o nome do Imposto:\n");
		String nomeImposto = scanner.nextLine();
		imposto.setNomeImposto(nomeImposto);

		System.out.println("Digite a taxa do Imposto:\n");
		double taxaImposto = scanner.nextDouble();
		imposto.setTaxaImposto(taxaImposto);
		
		impostos.add(imposto);

		return impostos;
	}
}
