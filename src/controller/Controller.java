package controller;

import view.MainFrame;
import view.MainView;
import view.*;

public class Controller {

	static MainView view;
	
	public Controller(){
		MainView view = new MainView();
	}
	
// TEMPORARY: FOR TESTING
	
	public static double[][] editTest(int index){
		if(view.getObject(index) instanceof PointDrawer){
			double[][] test = {{10, -10}};
			return test;
		}
		else if(view.getObject(index) instanceof LineDrawer){
			double[][] test = {{10, -10},
							   {0, 0}};
			return test;
		}
		else if(view.getObject(index) instanceof EllipseDrawer){
			double[][] test = {{5, 5},
							   {10, 4}};
			return test;
		}
		else if(view.getObject(index) instanceof PolygonDrawer){
			double[][] test = {{5, 5},
							   {10, 0},
							   {5, -5},
							   {0, 0}};
			return test;
		}
		else if(view.getObject(index) instanceof ParabolaDrawer){
			double[][] test = {{-5, -5},
							   {4, 4}};
			return test;
		}
		else{
			double[][] test = {{-5, -5},
					   		   {4, 6},
					   		   {1, 0}};
			return test;
		}
	}
	
// ADDING
	
	public static boolean addPoint(double x, double y) {
		System.out.println("Controller: addPoint (" + x + ", " + y + ")");
		// add point to model
		return true;
	}
	
	public static boolean addLine(double x1, double y1, double x2, double y2) {
		System.out.println("Controller: addLine (" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ")");
		// add line to model
		return true;
	}
	
	public static boolean addEllipse(double x, double y, double w, double h) {
		System.out.println("Controller: addEllipse (" + x + ", " + y + ", " + w + ", " + h + ")");
		// add ellipse to model
		return true;
	}
	
	public static boolean addPolygon(double[][] p) {
		System.out.println("Controller: addPolygon");
		// add polygon to model
		return true;
	}
	
	public static boolean addParabola(double x, double y, double f, int d) {
		System.out.println("Controller: addParabola (" + x + ", " + y + ", " + f + ", " + d);
		// add parabola to model
		return true;
	}
	
	public static boolean addHyperbola(double x, double y, double xd, double yd, int d) {
		System.out.println("Controller: addHyperbola (" + x + ", " + y + ", " + xd + ", " + yd + ", " + d);
		// add hyperbola to model
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
		return editTest(index); // temporary (return null means there was an error)
	}
	
	/* Rotates object
	 * @param index index in the list of object to be edited
	 * @param deg   value of rotation in degrees
	 * @return new matrix data of object*
	 */
	public static double[][] rotateObject(int index, double deg) {
		// rotate object in model
		return editTest(index); // temporary (return null means there was an error)
	}
	
	/* Shears object
	 * @param index index in the list of object to be edited
	 * NOTE: I STILL DON'T KNOW WHAT YOU NEED FOR SHEARING
	 * @return new matrix data of object*
	 */
	public static double[][] shearObject(int index) { // NOTE TO CLARISSE: FIX THIS
		// rotate object in model
		return editTest(index); // temporary (return null means there was an error)
	}
	
	/* Scales object
	 * @param index index in the list of object to be edited
	 * @param value scaling value
	 * @return new matrix data of object*
	 */
	public static double[][] scaleObject(int index, double value) {
		// rotate object in model
		return editTest(index); // temporary (return null means there was an error)
	}
	
	/* Reflects object
	 * @param index index in the list of object to be edited
	 * @param type  type of reflection (MainView.REFLECT_X or MainView.REFLECT_Y)
	 * @return new matrix data of object*
	 */
	public static double[][] reflectObject(int index, int type) {
		// rotate object in model
		return editTest(index); // temporary (return null means there was an error)
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
