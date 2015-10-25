package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class GraphicObject extends Canvas {
	
	boolean isRed; // true if object will be drawn red, false otherwise

	/* Draws object
	 * g Graphics object
	 */
	public void paint(Graphics g){
		// Converts Graphics object to Graphics2D object
		Graphics2D g2d = (Graphics2D)g;

		// Sets color
		if(isRed) {
			g2d.setColor(Color.red);
		}
		else {
			g2d.setColor(Color.blue);
		}
		
		// Calls specific drawing function of object
		paintObject(g2d);
	}
	
	/* Specific drawing function
	 * g2d Graphics2D object
	 */
	public abstract void paintObject(Graphics2D g2d);
	
// SETTERS
	
	/* Changes color setting
	 * @param r true if object should be drawn red, false otherwise
	 */
	public void setIsRed(boolean r){
		isRed = r;
	}
	
}
