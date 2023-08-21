public class Imposto {

	private double taxaImposto;
	private String nomeImposto;
	
	//Construtor
	public Imposto(String nomeImposto, double taxaImposto) {
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

	
}
