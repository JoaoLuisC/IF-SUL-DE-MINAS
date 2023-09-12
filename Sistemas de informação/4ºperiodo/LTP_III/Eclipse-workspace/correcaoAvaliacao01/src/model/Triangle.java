package model;

public class Triangle implements Shape{
	
	private double widht;
	private double height;
	
	public Triangle (double widht, double height) {
		this.widht = widht;
		this.height = height;
	}
	
	
	@Override
	public String name() {
		return "Triangulo";
	}

	@Override
	public double area() {
		
		return (this.widht * this.height) / 2;
	}

}
