package view;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class EllipseDrawer extends GraphicObject {

	double xCoord; // x coordinate of center
	double yCoord; // y coordinate of center
	double width;
	double height;
	
	/* Constructor
	 * @param x x coordinate of center
	 * @param y y coordinate of center
	 * @param w width
	 * @param h height
	 */
	public EllipseDrawer(double x, double y, double w, double h) {
		xCoord = x;
		yCoord = y;
		width  = w;
		height = h;
		isRed  = false;
	}
	
	/* Draws ellipse
	 * @param g2d Graphics2D object
	 */
	public void paintObject(Graphics2D g2d) {
		Shape theCircle = new Ellipse2D.Double(312 + ((xCoord - width/2) * 13),
											   312 + ((yCoord + height/2) * -13),
											   width * 13, height * 13);
		g2d.draw(theCircle);
	}
	
// GETTERS
	
	/* Returns center x coordinate value
	 * @return center x coordinate value
	 */
	public double getXCoord(){
		return xCoord;
	}
	
	/* Returns center y coordinate value
	 * @return center y coordinate value
	 */
	public double getYCoord(){
		return yCoord;
	}

}
