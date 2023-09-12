package view;

import model.Circle;
import model.Rect;
import model.Square;
import model.Triangle;

public class Main {
	public static void main(String[] agr) {

		Square s1 = new Square(10);
		Rect r1 = new Rect(10, 5);
		Circle c1 = new Circle(5);
		Triangle t1 = new Triangle(4, 3);

		Canvas c = new Canvas();

		c.addShape(c1);
		c.addShape(r1);
		c.addShape(s1);
		c.addShape(t1);

		c.printShape();

	}
}
