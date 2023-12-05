package model.empregado;

public class Manager extends Employee {

	private int subordinado;
	private double percentPerSubordinado;
	private int doneProjects;
	private double bonusPerProject;

	public Manager(String name, String role, double salary, int sub, double percent, 
			int done, double bonus) {
		super(name, "Líder Técnico", salary);
		this.subordinado = sub;
		this.percentPerSubordinado = percent / 100;

		this.doneProjects = done;
		this.bonusPerProject = bonus;
	}

	@Override
	public double salary() {
		double baseSalary = getSalary();
		double extraEarnigns = getExtraHours() * getPerExtraHourValue();

		double valuesPerSub = getSalary() * percentPerSubordinado;
		double extraBonus = valuesPerSub * subordinado;
		double projectBonus = doneProjects * bonusPerProject;

		return baseSalary + extraEarnigns + extraBonus + projectBonus;
	}

}
