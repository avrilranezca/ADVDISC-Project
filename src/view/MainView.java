package view;

import java.util.ArrayList;

import javax.swing.JFrame;

import controller.Controller;

public class MainView {

	private static ArrayList<GraphicObject> objectList = new ArrayList<GraphicObject>();
	private int selectedObject = 0;
	private JFrame mainFrame;
	
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
	
	public MainView(){
		mainFrame = new MainFrame(this);
		
		// Test objects
//		objectList.add(new RectangleDrawer(-10, 5, 10, 5, false));
//		objectList.add(new PointDrawer(-10, 5, false));
//		objectList.add(new EllipseDrawer(0, 0, 4, 2, false));
//		objectList.add(new LineDrawer(0, 1, 5, 6, false));
//		objectList.add(new HyperbolaDrawer(1, 1, 5, 1, false));
	}
	
// GETTERS
	
	public int getSelectedObject(){
		return selectedObject;
	}
	
	public static GraphicObject getObject(int index){
		return objectList.get(index);
	}
	
	public int getObjectCount(){
		return objectList.size();
	}
	
// SETTERS
	
	public void movePrevObject(){
		if(selectedObject == 0){
			selectedObject = objectList.size() - 1;
		}
		else {
			selectedObject = (selectedObject - 1) % objectList.size();
		}
		refreshGrid();
	}
	
	public void moveNextObject(){
		if(selectedObject == objectList.size() - 1){
			selectedObject = 0;
		}
		else {
			selectedObject = (selectedObject + 1) % objectList.size();
		}
		refreshGrid();
	}
	
	public void refreshGrid(){
		System.out.println("MainView: refreshGrid");
		((MainFrame) mainFrame).refreshGrid();
	}
	
// ADDING OBJECTS
	
	public void addPoint(double x, double y){
		System.out.println("MainView: addPoint (" + x + ", " + y + ")");
		objectList.add(new PointDrawer(x, y, false));
		selectedObject = objectList.size() - 1;
		refreshGrid();
	}
	
	public void addLine(double x1, double y1, double x2, double y2){
		System.out.println("MainView: addLine (" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ")");
		objectList.add(new LineDrawer(x1, y1, x2, y2, false));
		selectedObject = objectList.size() - 1;
		refreshGrid();
	}
	
	public void addEllipse(double x, double y, double w, double h){
		System.out.println("MainView: addEllipse (" + x + ", " + y + ", " + w + ", " + h + ")");
		objectList.add(new EllipseDrawer(x, y, w, h, false));
		selectedObject = objectList.size() - 1;
		refreshGrid();
	}
	
	public void addPolygon(double[][] p){
		System.out.println("MainView: addPolygon");
		objectList.add(new PolygonDrawer(p, false));
		selectedObject = objectList.size() - 1;
		refreshGrid();
	}
	
	public void addParabola(double x, double y, double f, int d){
		System.out.println("MainView: addParabola (" + x + ", " + y + ", " + f + ", " + d + ")");
		objectList.add(new ParabolaDrawer(x, y, f, d, false));
		selectedObject = objectList.size() - 1;
		refreshGrid();
	}
	
	public void addHyperbola(double x, double y, double xd, double yd, int d){
		System.out.println("MainView: addHyperbola (" + x + ", " + y + ", " + xd + ", " + yd + ", " + d + ")");
		objectList.add(new HyperbolaDrawer(x, y, xd, yd, d, false));
		selectedObject = objectList.size() - 1;
		refreshGrid();
	}
	
// UPDATING OBJECTS
	
	public void updateObject(GraphicObject previous, int index, double[][] data){
		GraphicObject o = objectList.get(index);
		
		if(o instanceof PointDrawer){
			objectList.set(index, new PointDrawer(data[0][0], data[0][1], false));
		}
		else if(o instanceof LineDrawer){
			objectList.set(index, new LineDrawer(data[0][0], data[0][1], data[1][0], data[1][1], false));
		}
		else if(o instanceof EllipseDrawer){
			objectList.set(index, new EllipseDrawer(data[0][0], data[0][1], data[1][0], data[1][1], false));
		}
		else if(o instanceof PolygonDrawer){
			objectList.set(index, new PolygonDrawer(data, false));
		}
		else if(o instanceof ParabolaDrawer){
			objectList.set(index, new ParabolaDrawer(data[0][0], data[0][1], data[1][0], (int)data[1][1], false));
		}
		else if(o instanceof PolygonDrawer){
			objectList.set(index, new HyperbolaDrawer(data[0][0], data[0][1], data[1][0], data[1][1], (int)data[2][0], false));
		}
		
		objectList.add(previous);
		refreshGrid();
	}
	
	public void applyEdit(){
		objectList.remove(objectList.size() - 1);
		refreshGrid();
	}
	
// DELETING OBJECTS
	
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
