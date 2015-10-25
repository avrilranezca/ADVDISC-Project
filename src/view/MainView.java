package view;

import java.util.ArrayList;

import javax.swing.JFrame;

import controller.Controller;

public class MainView {

	private static ArrayList<GraphicObject> objectList;     // List of objects
	private int 							selectedObject; // Index of selected

	private JFrame mainFrame;
	
	// Constants
	public static int PARABOLA_RIGHT = 1;
	public static int PARABOLA_LEFT  = 2;
	public static int PARABOLA_UP    = 3;
	public static int PARABOLA_DOWN  = 4;
	public static int HYPERBOLA_HOR  = 1;
	public static int HYPERBOLA_VERT = 2;
	public static int EDIT_TRANSLATE = 1;
	public static int EDIT_ROTATE    = 2;
	public static int EDIT_SHEAR     = 3;
	public static int EDIT_SCALE     = 4;
	public static int EDIT_REFLECT   = 5;
	public static int EDIT_DELETE    = 6;
	public static int ROTATE_90      = 1;
	public static int ROTATE_180     = 2;
	public static int ROTATE_270     = 3;
	public static int REFLECT_X      = 1;
	public static int REFLECT_Y	     = 2;
	public static int SHEAR_X        = 1;
	public static int SHEAR_Y        = 2;
	
	public MainView(){
		mainFrame      = new MainFrame(this);			 // Create window
		objectList     = new ArrayList<GraphicObject>(); // Create object list
		selectedObject = 0;								 // Set selected object
	}
	
// GETTERS
	
	/* Gets selected object index
	 * @return index of selected object
	 */
	public int getSelectedObject(){
		return selectedObject;
	}
	
	/* Gets object
	 * @param index index of desired object
	 * @return object corresponding to the given index
	 */
	public static GraphicObject getObject(int index){
		return objectList.get(index);
	}
	
	/* Gets number of objects
	 * @return number of objects in list
	 */
	public int getObjectCount(){
		return objectList.size();
	}
	
// SETTERS
	
	/* Selects previous object
	 * @return true if successful, false otherwise
	 */
	public boolean movePrevObject(){
		if(objectList.size() > 0){
			if(selectedObject == 0){
				selectedObject = objectList.size() - 1;
			}
			else {
				selectedObject = (selectedObject - 1) % objectList.size();
			}
			refreshGrid();
			return true;
		}
		return false;
	}
	
	/* Selects next object
	 * @return true if successful, false otherwise
	 */
	public boolean moveNextObject(){
		if(objectList.size() > 0){
			if(selectedObject == objectList.size() - 1){
				selectedObject = 0;
			}
			else {
				selectedObject = (selectedObject + 1) % objectList.size();
			}
			refreshGrid();
			return true;
		}
		return false;
	}
	
	/* Redraws grid and objects
	 */
	public void refreshGrid(){
		System.out.println("MainView.refreshGrid()");
		((MainFrame) mainFrame).refreshGrid();
	}
	
// ADDING OBJECTS
	
	/* Adds point to display
	 * @param x x coordinate of point
	 * @param y y coordinate of point
	 */
	public void addPoint(double x, double y){
		System.out.println("MainView.addPoint(" + x + ", " + y + ")");
		objectList.add(new PointDrawer(x, y));
		selectedObject = objectList.size() - 1;
		refreshGrid();
	}

	/* Adds line segment to display
	 * @param x1 x coordinate of first point
	 * @param y1 y coordinate of first point
	 * @param x2 x coordinate of second point
	 * @param y2 y coordinate of second point
	 */
	public void addLine(double x1, double y1, double x2, double y2){
		System.out.println("MainView.addLine(" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ")");
		objectList.add(new LineDrawer(x1, y1, x2, y2));
		selectedObject = objectList.size() - 1;
		refreshGrid();
	}
	
	/* Adds ellipse to display
	 * @param x x coordinate of center
	 * @param y y coordinate of center
	 * @param w width
	 * @param h height
	 */
	public void addEllipse(double x, double y, double w, double h){
		System.out.println("MainView.addEllipse(" + x + ", " + y + ", " + w + ", " + h + ")");
		objectList.add(new EllipseDrawer(x, y, w, h));
		selectedObject = objectList.size() - 1;
		refreshGrid();
	}
	
	/* Adds polygon to display
	 * @param p points defining the polygon
	 *		  p[n][0] -> x coordinate of point n
	 *		  p[n][1] -> y coordinate of point n
	 */
	public void addPolygon(double[][] p){
		System.out.println("MainView: addPolygon");
		objectList.add(new PolygonDrawer(p));
		selectedObject = objectList.size() - 1;
		refreshGrid();
	}
	
	/* Adds parabola to display
	 * @param x x coordinate of vertex
	 * @param y y coordinate of vertex
	 * @param f focal length
	 * @param d direction of opening (MainView.PARABOLA_RIGHT
	 *								  || MainView.PARABOLA_LEFT
	 *								  || MainView.PARABOLA_UP
	 *								  || MainView.PARABOLA_DOWN)
	 */
	public void addParabola(double x, double y, double f, int d){
		System.out.println("MainView: addParabola (" + x + ", " + y + ", " + f + ", " + d + ")");
		objectList.add(new ParabolaDrawer(x, y, f, d));
		selectedObject = objectList.size() - 1;
		refreshGrid();
	}
	
	/* Adds parabola to display
	 * @param x  x coordinate of vertex
	 * @param y  y coordinate of vertex
	 * @param xd x distance
	 * @param yd y distance
	 * @param d  direction of opening (MainView.HYPERBOLA_HOR
	 *								   || HYPERBOLA_VERT)
	 */
	public void addHyperbola(double x, double y, double xd, double yd, int d){
		System.out.println("MainView: addHyperbola (" + x + ", " + y + ", " + xd + ", " + yd + ", " + d + ")");
		objectList.add(new HyperbolaDrawer(x, y, xd, yd, d));
		selectedObject = objectList.size() - 1;
		refreshGrid();
	}
	
// UPDATING OBJECTS
	
	/* Updates data of given object
	 * @param previous data of object before editing
	 * @param index    index of object to be updated
	 * @param data     data of edited object
	 */
	public void updateObject(GraphicObject previous, int index, double[][] data){
		GraphicObject o = objectList.get(index);
		
		if(o instanceof PointDrawer){
			objectList.set(index, new PointDrawer(data[0][0], data[0][1]));
		}
		else if(o instanceof LineDrawer){
			objectList.set(index, new LineDrawer(data[0][0], data[0][1], data[1][0], data[1][1]));
		}
		else if(o instanceof EllipseDrawer){
			objectList.set(index, new EllipseDrawer(data[0][0], data[0][1], data[1][0], data[1][1]));
		}
		else if(o instanceof PolygonDrawer){
			objectList.set(index, new PolygonDrawer(data));
		}
		else if(o instanceof ParabolaDrawer){
			objectList.set(index, new ParabolaDrawer(data[0][0], data[0][1], data[1][0], (int)data[1][1]));
		}
		else if(o instanceof HyperbolaDrawer){
			objectList.set(index, new HyperbolaDrawer(data[0][0], data[0][1], data[1][0], data[1][1], (int)data[2][0]));
		}
		
		objectList.add(previous);
		refreshGrid();
	}
	
	/* Removes display of object before edit
	 */
	public void applyEdit(){
		objectList.remove(objectList.size() - 1);
		refreshGrid();
	}
	
// DELETING OBJECTS
	
	/* Deletes an object
	 * @param index index of object to delete
	 */
	public void deleteObject(int index){
		objectList.remove(index);
		if(selectedObject == index){
			if(index > 0){
				selectedObject--;
			}
			else{
				selectedObject = objectList.size() - 1;
			}
		}
		refreshGrid();
	}
	
// GETTING CONSTANT VALUES
	
	/* Returns string describing the parabola direction given
	 * @param d integer representing the direction
	 * @return string describing direction
	 */
	public static String getPDirectionString(int d){
		if(d == PARABOLA_RIGHT){
			return "Opening Right";
		}
		else if(d == PARABOLA_LEFT){
			return "Opening Left";
		}
		else if(d == PARABOLA_UP){
			return "Opening Up";
		}
		else if(d == PARABOLA_DOWN){
			return "Opening Down";
		}
		else{
			return "";
		}
	}
	
	/* Returns string describing the hyperbola direction given
	 * d integer representing the direction
	 * @return string describing direction
	 */
	public static String getHDirectionString(int d){
		if(d == HYPERBOLA_HOR){
			return "Opening Right & Left";
		}
		else if(d == HYPERBOLA_VERT){
			return "Opening Up & Down";
		}
		else{
			return "";
		}
	}
}
