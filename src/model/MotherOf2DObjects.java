package model;

import java.util.ArrayList;

import view.EllipseDrawer;
import view.LineDrawer;
import view.MainView;
import view.ParabolaDrawer;
import view.PointDrawer;
import view.PolygonDrawer;

public class MotherOf2DObjects {
	private ArrayList<Object2D> objects;
	
	public MotherOf2DObjects() {
		objects = new ArrayList<Object2D>();
	}
	
	public void addObject(Object2D object) {
		objects.add(object);
	}
	
	public void removeObject(int index) {
		objects.remove(index);
	}
	
	/* Adds a point
	 * @param x x coordinate of the point
	 * @param y y coordinate of the point
	 * @return true if adding to model was successful, false otherwise
	 */
	public boolean addPoint(double x, double y) {
		System.out.println("Controller: addPoint (" + x + ", " + y + ")");
		objects.add(new Point(x, y));
		return true;
	}
	
	/* Adds a line segment
	 * @param x1 x coordinate of the first point
	 * @param y1 y coordinate of the second point
	 * @param x2 x coordinate of the first point
	 * @param y2 y coordinate of the second point
	 * @return true if adding to model was successful, false otherwise
	 */
	public boolean addLine(double x1, double y1, double x2, double y2) {
		System.out.println("Controller: addLine (" + x1 + ", " + y1 + ", " + x2
							+ ", " + y2 + ")");
		objects.add(new Line(new Point(x1, y1), new Point(x2, y2)));
		return true;
	}
	
	/* Adds a ellipse
	 * @param x x coordinate of the center
	 * @param y y coordinate of the center
	 * @param w width
	 * @param h height
	 * @return true if adding to model was successful, false otherwise
	 */
	public boolean addEllipse(double x, double y, double w, double h) {
		System.out.println("Controller: addEllipse (" + x + ", " + y + ", " + w
							+ ", " + h + ")");
		objects.add(new Ellipse(new Point(x, y), h, w));
		return true;
	}
	
	/* Adds a polygon
	 * @param p array containing the points of the polygon
	 *		  p[n][0] -> x coordinate of point n
	 *		  p[n][1] -> y coordinate of point n
	 * @return true if adding to model was successful, false otherwise
	 */
	public boolean addPolygon(double[][] p) {
		System.out.println("Controller: addPolygon");
		Point points[] = new Point[p.length];
		for(int i = 0; i < p.length; i++) {
			points[i] = new Point(p[i][0], p[i][1]);
		}
		objects.add(new Polygon(points));
		return true;
	}
	
	/* Adds a parabola
	 * @param x x coordinate of the vertex
	 * @param y y coordinate of the vertex
	 * @param f focal length
	 * @param d direction (MainView.PARABOLA_RIGHT || MainView.PARABOLA_LEFT
	 						|| MainView.PARABOLA_UP || MainView.PARABOLA_DOWN)
	 * @return true if adding to model was successful, false otherwise
	 */
	public boolean addParabola(double x, double y, double f, int d) {
		System.out.println("Controller: addParabola (" + x + ", " + y + ", " + f
							+ ", " + d);
		Point focus = null;
		if(d == MainView.PARABOLA_UP) {
			focus = new Point(x, y+f);
		} else if (d == MainView.PARABOLA_DOWN) {
			focus = new Point(x, y-f);
		} else if (d == MainView.PARABOLA_LEFT) {
			focus = new Point(x-f, y);
		} else if (d == MainView.PARABOLA_RIGHT) {
			focus = new Point(x+f, y);
		}
		objects.add(new Parabola(new Point(x, y), focus, f, d));
		return true;
	}
	
	/* Adds a hyperbola
	 * @param x  x coordinate of the vertex
	 * @param y  y coordinate of the vertex
	 * @param xd x distance
	 * @param yd y distance
	 * @param d  direction (MainView.HYPERBOLA_HOR || MainView.HYPERBOLA_VERT)
	 * @return true if adding to model was successful, false otherwise
	 */
	public boolean addHyperbola(double x, double y, double xd, double yd,
									   int d) {
		System.out.println("Controller: addHyperbola (" + x + ", " + y + ", "
							+ xd + ", " + yd + ", " + d);
		objects.add(new Hyperbola(new Point(x, y), xd, yd, d));
		return true;
	}
	
	public Object2D getObject(int index) {
		return objects.get(index);
	}
	
	public double[][] getObjectArray(int index) {
		double array[][] = null;
		Object2D object = objects.get(index);
		
		if(object instanceof Point) {
			array = new double[1][2];
			array[0][0] = ((Point) object).getX();
			array[0][1] = ((Point) object).getY();
		} else if(object instanceof Line){
			array = new double[2][2];
			array[0][0] = ((Line) object).getHead().getX();
			array[0][1] = ((Line) object).getHead().getY();
			array[1][0] = ((Line) object).getTail().getX();
			array[1][1] = ((Line) object).getTail().getY();
		} else if(object instanceof Ellipse){
			array = new double[2][2];
			array[0][0] = ((Ellipse) object).getCenter().getX();
			array[0][1] = ((Ellipse) object).getCenter().getY();
			array[1][0] = ((Ellipse) object).getWidth();
			array[1][1] = ((Ellipse) object).getHeight();
		} else if(object instanceof Polygon){
			array = new double[((Polygon) object).getPoints().length][2];
			for(int i = 0; i < array.length; i++) {
				array[i][0] = ((Polygon) object).getPoints()[i].getX();
				array[i][1] = ((Polygon) object).getPoints()[i].getY();
			}
		} else if(object instanceof Parabola){
			array = new double[2][2];
			array[0][0] = ((Parabola) object).getVertex().getX();
			array[0][1] = ((Parabola) object).getVertex().getY();
			array[1][0] = ((Parabola) object).getFocalLength();
			array[1][1] = ((Parabola) object).getDirection();
		} else if(object instanceof Hyperbola){
			array = new double[3][2];
			array[0][0] = ((Hyperbola) object).getCenter().getX();
			array[0][1] = ((Hyperbola) object).getCenter().getY();
			array[1][0] = ((Hyperbola) object).getHorizontalDistance();
			array[1][1] = ((Hyperbola) object).getVerticalDistance();
			array[2][0] = ((Hyperbola) object).getDirection();
		}
		
		return array;
	}
}
