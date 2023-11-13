package model.empregado;

public class analista extends Employee{

	public analista(String name, double salary) {
		super(name,"analista",salary);
	}

	@Override
	public double salary() {
		double baseSalary = getSalary();
		double extraEarnigns = getExtraHours() * getPerExtraHourValue();
		return baseSalary + extraEarnigns;
	}

}
