package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class PolygonDrawer extends GraphicObject {
	
	double[][] points; /* list of all points that define the polygon
	   					*      points[n][0] -> x coordinate of point n
	   					*	   points[n][1] -> y coordinate of point n
	   					*/
	
	/* Constructor
	 * @param p list of points that define the polygon
	 */
	public PolygonDrawer(double[][] p){
		points = p;
		isRed  = false;
	}
	
	/* Draws polygon
	 * @param g2d Graphics2D objecy
	 */
	public void paintObject(Graphics2D g2d) {
		// Path of polygon
		GeneralPath polygon =  new GeneralPath(GeneralPath.WIND_EVEN_ODD,
											   points.length);
		
		// Starts path at first point
		polygon.moveTo(312 + (points[0][0] * 13), 312 + (points[0][1] * -13));

		// Continues path through other points
		for (int i = 1; i < points.length; i++) {
		    polygon.lineTo(312 + (points[i][0] * 13),
		    			   312 + (points[i][1] * -13));
		};

		// Closes path
		polygon.closePath();
		
		// Draws polygon
		g2d.draw(polygon);
	}
	
// GETTERS
	
	/* Returns x coordinate of given index
	 * @param index index of point
	 * @return x coordinate of given index
	 */
	public double getXCoord(int index){
		return points[index][0];
	}
	
	/* Returns y coordinate of given index
	 * @param index index of point
	 * @return y coordinate of given index
	 */
	public double getYCoord(int index){
		return points[index][1];
	}
	
	/* Returns number of points in polygon
	 * @return number of points in polygon
	 */
	public int getPointCount(){
		return points.length;
	}
}
