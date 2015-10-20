package driver;

import model.GraphicObject;
import model.Line;
import model.Parabola;
import model.Point;
import model.Polygon;

public class Main {

	public static void main(String[] args) {
		Point[] points = new Point[4];
		points[0] = new Point(-1, 1);
		points[1] = new Point(1, 1);
		points[2] = new Point(1, -1);
		points[3] = new Point(-1, -1);
		Polygon polygon = new Polygon(points);
		polygon.shearX(45);
		System.out.println(polygon);
	}
}
