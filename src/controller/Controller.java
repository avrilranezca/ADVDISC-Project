package controller;

import model.MotherOf2DObjects;
import view.*;

public class Controller {

	static MainView view;
	static MotherOf2DObjects holder;
	
	public Controller(){
		MainView view = new MainView();
		holder = new MotherOf2DObjects();
	}
	
// ADDING

	/* Adds a point
	 * @param x x coordinate of the point
	 * @param y y coordinate of the point
	 * @return true if adding to model was successful, false otherwise
	 */
	public static boolean addPoint(double x, double y) {
		System.out.println("Controller: addPoint (" + x + ", " + y + ")");
		holder.addPoint(x, y);
		return true;
	}
	
	/* Adds a line segment
	 * @param x1 x coordinate of the first point
	 * @param y1 y coordinate of the second point
	 * @param x2 x coordinate of the first point
	 * @param y2 y coordinate of the second point
	 * @return true if adding to model was successful, false otherwise
	 */
	public static boolean addLine(double x1, double y1, double x2, double y2) {
		System.out.println("Controller: addLine (" + x1 + ", " + y1 + ", " + x2
							+ ", " + y2 + ")");
		holder.addLine(x1, y1, x2, y2);
		return true;
	}
	
	/* Adds a ellipse
	 * @param x x coordinate of the center
	 * @param y y coordinate of the center
	 * @param w width
	 * @param h height
	 * @return true if adding to model was successful, false otherwise
	 */
	public static boolean addEllipse(double x, double y, double w, double h) {
		System.out.println("Controller: addEllipse (" + x + ", " + y + ", " + w
							+ ", " + h + ")");
		holder.addEllipse(x, y, w, h);
		return true;
	}
	
	/* Adds a polygon
	 * @param p array containing the points of the polygon
	 *		  p[n][0] -> x coordinate of point n
	 *		  p[n][1] -> y coordinate of point n
	 * @return true if adding to model was successful, false otherwise
	 */
	public static boolean addPolygon(double[][] p) {
		System.out.println("Controller: addPolygon");
		holder.addPolygon(p);
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
	public static boolean addParabola(double x, double y, double f, int d) {
		System.out.println("Controller: addParabola (" + x + ", " + y + ", " + f
							+ ", " + d);
		holder.addParabola(x, y, f, d);
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
	public static boolean addHyperbola(double x, double y, double xd, double yd,
									   int d) {
		System.out.println("Controller: addHyperbola (" + x + ", " + y + ", "
							+ xd + ", " + yd + ", " + d);
		holder.addHyperbola(x, y, xd, yd, d);
		return true;
	}
	
// EDITING
	
	/* Translates object
	 * @param index index in the list of object to be edited
	 * @param x     x translation value
	 * @param y     y translation value
	 * @return new matrix data of object*
	 */
	public static double[][] translateObject(int index, double x, double y) {
		// translate object in model
		holder.getObject(index).translate(y, x);
		return holder.getObjectArray(index);
	}
	
	/* Rotates object
	 * @param index index in the list of object to be edited
	 * @param deg   value of rotation in degrees
	 * @return new matrix data of object*
	 */
	public static double[][] rotateObject(int index, double deg) {
		// rotate object in model
		holder.getObject(index).rotate(deg);
		return holder.getObjectArray(index);
	}
	
	/* Shears object
	 * @param index index in the list of object to be edited
	 * @param deg   value of shearing in degrees
	 * @param axis  axis for shearing (MainView.SHEAR_X or MainView.SHEAR_Y)
	 * @return new matrix data of object*
	 */
	public static double[][] shearObject(int index, double deg, int axis) {
		// rotate object in model
		holder.getObject(index).shearX(deg);
		return holder.getObjectArray(index);
	}
	
	/* Scales object
	 * @param index index in the list of object to be edited
	 * @param x     horizontal scaling value
	 * @param y		vertical scaling value
	 * @return new matrix data of object*
	 */
	public static double[][] scaleObject(int index, double x, double y) {
		// rotate object in model
		holder.getObject(index).rescaleX(x);
		holder.getObject(index).rescaleY(y);
		return holder.getObjectArray(index);
	}
	
	/* Reflects object
	 * @param index index in the list of object to be edited
	 * @param type  type of reflection (MainView.REFLECT_X or MainView.REFLECT_Y)
	 * @return new matrix data of object*
	 */
	public static double[][] reflectObject(int index, int type) {
		// rotate object in model
		if(type == MainView.REFLECT_X) {
			holder.getObject(index).reflectOverX();
		} else {
			holder.getObject(index).reflectOverY();
		}
		return holder.getObjectArray(index);
	}
	
	/* Deletes object
	 * @param index index in the list of object to be edited
	 * @return true if successfully deleted, false otherwise
	 */
	public static boolean deleteObject(int index) {
		// if able to delete in model
		holder.removeObject(index);
		return true; // else return false
	}
	
}

/* Matrix data (WHAT CLARISSE ASSUMED) (all of them are double[][])
 * ----------------------------------------------------------------------------
 * 
 * Point
 * [0][0] -> x coordinate
 * [0][1] -> y coordinate
 * 
 * Line Segment
 * [0][0] -> x coordinate (1st point)
 * [0][1] -> y coordinate (1st point)
 * [1][0] -> x coordinate (2nd point)
 * [1][1] -> y coordinate (2nd point)
 * 
 * Ellipse
 * [0][0] -> x coordinate (center)
 * [0][1] -> y coordinate (center)
 * [1][0] -> width
 * [1][1] -> height
 * 
 * Polygon
 * [n][0] -> x coordinate of point n
 * [n][1] -> y coordinate of point n
 * 
 * Parabola
 * [0][0] -> x coordinate (vertex)
 * [0][1] -> y coordinate (vertex)
 * [1][0] -> focal length
 * [1][1] -> direction (MainView.PARABOLA_RIGHT || MainView.PARABOLA_LEFT
 * 						|| MainView.PARABOLA_UP || MainView.PARABOLA_DOWN)
 * 
 * Hyperbola
 * [0][0] -> x coordinate (vertex)
 * [0][1] -> y coordinate (vertex)
 * [1][0] -> x distance
 * [1][1] -> y distance
 * [2][0] -> direction (MainView.HYPERBOLA_HOR || MainView.HYPERBOLA_VERT)
 */
