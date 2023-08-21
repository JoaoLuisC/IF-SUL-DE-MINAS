

public class Imposto {
	// Impostos em int ou short(ver se tem algum problema colocar em short dps)
	// Variaveis: Impostos

	private double ICMS, Confins, IPI, ISS, Cide, CSLL;
	private double somaImpostos;

	// GETTERS dos Impostos
	public double getICMS() {
		ICMS = 0.07;
		return ICMS;
	}
	public double getConfins() {
		Confins = 0.12;
		return Confins;
	}
	public double getIPI() {
		IPI = 0.08;
		return IPI;
	}
	public double getISS() {
		ISS = 0.05;
		return ISS;
	}
	public double getCide() {
		Cide = 0.10;
		return Cide;
	}
	public double getCSLL() {
		CSLL = 0.04;
		return CSLL;
	}

	// metodos Para calcular a soma dos impostos escolhidos para definir o preço
	// final do produto

	public double SomaImpostos1(double impostoA) {

		somaImpostos = impostoA;

		return somaImpostos;
	}

	public double SomaImpostos2(double impostoA,double impostoB) {

		somaImpostos = impostoA+impostoB;

		return somaImpostos;
	}

	public double SomaImpostos3(double impostoA,double impostoB,double impostoC) {

		somaImpostos = impostoA+impostoB+impostoC;

		return somaImpostos;
	}
	
	public double SomaImpostos4(double impostoA,double impostoB,double impostoC,double impostoD) {

		somaImpostos = impostoA+impostoB+impostoC+ impostoD;

		return somaImpostos;
	}

	
}
