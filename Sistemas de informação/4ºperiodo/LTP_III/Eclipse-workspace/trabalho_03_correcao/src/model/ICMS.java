package model;

public  class ICMS extends Tax {
	
	private static final double INDUSTRIAL_ALIQUOT = 5;
	private static final double NO_INDUSTRIAL_ALIQUOT = 7;

	public ICMS() throws Exception {
		super("ICMS", "Imposto sobre circulação de mercadorias");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate(Product p) {
		double icmsCost = p.getCostPrice() * getAliquot();
		return icmsCost;
	}

	@Override
	public void defineAliquot(Product p) {
		if(p.isIndustrial())
			setAliquot(INDUSTRIAL_ALIQUOT);
		else
			setAliquot(NO_INDUSTRIAL_ALIQUOT);		
	}
	
}
