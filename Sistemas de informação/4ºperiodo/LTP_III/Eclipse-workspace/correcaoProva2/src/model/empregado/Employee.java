package model.empregado;

public abstract class Employee {

	private String name;
	private String role;// Cargo
	private double salary;
	private double perExtraHourValue;
	private double extraHours;

	public Employee(String name, String role, double salary) {
		this.name = name;
		this.role = role;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public double getSalary() {
		return salary;
	}

	public double getPerExtraHourValue() {
		return perExtraHourValue;
	}

	public double getExtraHours() {
		return extraHours;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setPerExtraHourValue(double perExtraHourValue) {
		this.perExtraHourValue = perExtraHourValue;
	}

	public void setExtraHours(double extraHours) {
		this.extraHours = extraHours;
	}

	public abstract double salary();

}
