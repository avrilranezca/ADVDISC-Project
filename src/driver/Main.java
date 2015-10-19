package driver;

import model.GraphicObject;
import model.Line;
import model.Parabola;
import model.Point;

public class Main {

	public static void main(String[] args) {
		/*GraphicObject shape = new Line(new Point(1, 3), new Point(4, 2));
		shape.rescaleX(0.5);
		System.out.println( ((Line) shape).getTail());*/
		
		GraphicObject shape = new Parabola(new Point(2, -1), new Point(2, 1), "x", -3);
		System.out.println(((Parabola) shape).getVertex());
		shape.translate(3, 4);
		System.out.println( ((Parabola) shape).getVertex());
		System.out.println( ((Parabola) shape).getFocus());
		System.out.println( ((Parabola) shape).getDirectrixAxis() + "=" + ((Parabola) shape).getDirectrixValue());
	}
}
