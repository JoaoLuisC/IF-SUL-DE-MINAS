import java.util.ArrayList;
import java.util.Scanner;

public class Imposto {

	private double taxaImposto;
	private String nomeImposto;

	// Construtor
	public Imposto() {

	}

	public Imposto(String nomeImposto, double taxaImposto) {
		super();
		this.nomeImposto = nomeImposto;
		this.taxaImposto = taxaImposto;
	}

	// GETTERS imposto
	public double getTaxaImposto() {
		return taxaImposto;
	}

	public String getNomeImposto() {
		return nomeImposto;
	}

	// SETTERS imposto
	public void setTaxaImposto(double taxaImposto) {
		if(taxaImposto <= 0)
			throw new IllegalArgumentException("Valor Inválido!");
		this.taxaImposto = taxaImposto;
	}

	public void setNomeImposto(String nomeImposto) throws Exception {
		if (nomeImposto == null || nomeImposto.equals(""))
			throw new Exception("Nome Inválido!");
		this.nomeImposto = nomeImposto;
	}

	public static double SomaImpostos(Produto produto) {

		double somaImpostos = 0.0;

		ArrayList<Imposto> impostosDoProduto = produto.getImpostos();
		for (Imposto imposto : impostosDoProduto) {
			somaImpostos += imposto.getTaxaImposto();
		}

		return somaImpostos;
	}
	
	// metodo equals
		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (!(obj instanceof Imposto))
				return false;

			Imposto tax = (Imposto) obj;

			return this.nomeImposto.equals(tax.nomeImposto);
		}

	// StringFormat do imposto
	public String formatarImposto() {
		return String.format(" %s %.0f%%", nomeImposto, taxaImposto);
	}

	// Insere Imposto
	public static ArrayList<Imposto> insereImposto(ArrayList<Imposto> impostos) throws Exception {
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

	// Atualiza Imposto
	public static Imposto atualizaImposto(Imposto impostoAtualizado) throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome do Imposto:\n");
		String nomeImposto = scanner.nextLine();
		impostoAtualizado.setNomeImposto(nomeImposto);

		System.out.println("Digite a taxa do Imposto:\n");
		double taxaImposto = scanner.nextDouble();
		impostoAtualizado.setTaxaImposto(taxaImposto);

		return impostoAtualizado;
	}
}
