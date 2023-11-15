package model.empregado;

public class Arquiteto extends Employee {

	private int projects;
	private double percentualProjects;

	public Arquiteto(String name, double salary, int projects, double percentual) {
		super(name, "Arquiteto", salary);

		this.projects = projects;
		this.percentualProjects = percentual/100;

	}

	@Override
	public double salary() {
		double baseSalary = getSalary();
		double extraEarnigns = getExtraHours() * getPerExtraHourValue();
		double bonusPerProject = getSalary() * percentualProjects;
		double extraBonus = bonusPerProject * this.projects;
		return baseSalary + extraEarnigns + extraBonus;
	}

}
