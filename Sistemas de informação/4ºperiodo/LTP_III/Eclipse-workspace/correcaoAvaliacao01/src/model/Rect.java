package model;

public class Rect implements Shape{

	
	private double widht;
	private double height;
	
	public Rect(double widht, double height) {
		this.widht = widht;
		this.height = height;
	}

	@Override
	public String name() {
		return"Retângulo";
	}
	
	@Override
	public double area() {
		return this.widht * this.height;
	}
	
	
}
