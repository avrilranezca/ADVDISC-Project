package driver;

import model.Line;
import model.Point;
import model.Shape;

public class Main {

	public static void main(String[] args) {
		Shape shape = new Line(new Point(1, 3), new Point(4, 2));
		shape.rescaleX(0.5);
		System.out.println( ((Line) shape).getTail());
	}
}
