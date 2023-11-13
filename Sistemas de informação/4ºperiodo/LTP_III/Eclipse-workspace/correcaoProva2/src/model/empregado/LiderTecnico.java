package model.empregado;

public class LiderTecnico extends Employee {

	private int subordinado;
	private double percentPerSubordinado;
	
	
	public LiderTecnico(String name, String role, double salary,int sub, double percent) {
		super(name, "Líder Técnico", salary);
		this.subordinado = sub;
		this.percentPerSubordinado = percent/100;
	}

	@Override
	public double salary() {
		double baseSalary = getSalary();
		double extraEarnigns = getExtraHours() * getPerExtraHourValue();
		
		double valuesPerSub = getSalary()*percentPerSubordinado;
		double extraBonus = valuesPerSub * subordinado;
		
		return baseSalary + extraEarnigns + extraBonus;
	}

}
