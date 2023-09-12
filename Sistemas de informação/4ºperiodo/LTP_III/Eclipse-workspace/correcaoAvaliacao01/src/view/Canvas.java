package view;

import java.util.ArrayList;
import java.util.List;

import model.Shape;

public class Canvas {
	
	private List<Shape> shapes = new ArrayList<>();
	
	public void addShape(Shape shape) {
		if(shape != null)
			shapes.add(shape);
		
	}
	
	public void printShape() {
		for(Shape shape : shapes) {
			String s = String.format("Forma: %s - Area: %.2f", shape.name() , shape.area());
			System.out.println(s);
		}
	}
	
}
