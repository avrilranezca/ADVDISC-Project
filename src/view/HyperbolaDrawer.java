package view;

import java.awt.Graphics2D;

public class HyperbolaDrawer extends GraphicObject {

	double xCoord;    // x coordinate of vertex
	double yCoord;    // y coordinate of vertex
	double xDistance; // horizontal distance
	double yDistance; // vertical distance
	int    direction; // direction of opening
	
	/* Constructor
	 * @param x  x coordinate of vertex
	 * @param y  y coordinate of vertex
	 * @param xd horizontal distance
	 * @param yd vertical distance
	 * @param d  direction of opening
 	 */
	public HyperbolaDrawer(double x, double y, double xd, double yd, int d){
		xCoord      = x;
		yCoord      = y;
		xDistance   = xd;
		yDistance   = yd;
		direction   = d;
		isRed       = false;
	}
	
	/* Draws hyperbola
	 * @param g2d Graphics2D object
	 */
	public void paintObject(Graphics2D g2d) {

		// If hyperbola opens right and left
		if(direction == MainView.HYPERBOLA_HOR){
			double y = 0;
			double prevy;
			double prevx;
			
			for(int x = 0; x < 624; x++){
				
				if(x == 0){
					y  = (yDistance * 13 * Math.sqrt(Math.pow(x/(xDistance * 13), 2) - 1));
					prevy = y;
					prevx = x;
				}
				else{
					prevy = y;
					prevx = x - 1;
		            y = (yDistance * 13 * Math.sqrt(Math.pow(x/(xDistance * 13), 2) - 1));
		            if(Double.isNaN(prevy)){
						prevy = y;
						prevx = x;
					}
				}
				
				if(!Double.isNaN(y) && !Double.isNaN(x)){
					// Lower Right
					g2d.drawLine((int)(312 + prevx + xCoord * 13),
								 (int)(312 + prevy - yCoord * 13), 
								 (int)(312 + x + xCoord * 13),
								 (int)(312 + y - yCoord * 13));
					
					// Upper Right
					g2d.drawLine((int)(312 + prevx + xCoord * 13),
								 (int)(312 - prevy - yCoord * 13), 
								 (int)(312 + x + xCoord * 13),
								 (int)(312 - y - yCoord * 13));
					
					// Lower Left
					g2d.drawLine((int)(312 - prevx + xCoord * 13),
								 (int)(312 + prevy - yCoord * 13), 
								 (int)(312 - x + xCoord * 13),
								 (int)(312 + y - yCoord * 13));
					
					// Upper Left
					g2d.drawLine((int)(312 - prevx + xCoord * 13),
								 (int)(312 - prevy - yCoord * 13), 
								 (int)(312 - x + xCoord * 13),
								 (int)(312 - y - yCoord * 13));
				}
			}
		}

		// If hyperbola opens up and down
		else if(direction == MainView.HYPERBOLA_VERT){
			double x = 0;
			double prevy;
			double prevx;
			
			for(int y = 0; y < 624; y++){
				if(y == 0){
		            x = (xDistance * 13 * Math.sqrt(Math.pow(y/(yDistance * 13), 2) - 1));
					prevy = y;
					prevx = x;
				}
				else{
					prevy = y - 1;
					prevx = x;
		            x = (xDistance * 13 * Math.sqrt(Math.pow(y/(yDistance * 13), 2) - 1));
		            if(Double.isNaN(prevx)){
						prevy = y;
						prevx = x;
					}
				}
				
				if(!Double.isNaN(y) && !Double.isNaN(x)){
					// Lower Right
					g2d.drawLine((int)(312 + prevx + xCoord * 13),
								 (int)(312 + prevy - yCoord * 13), 
								 (int)(312 + x + xCoord * 13),
								 (int)(312 + y - yCoord * 13));
					
					// Upper Right
					g2d.drawLine((int)(312 + prevx + xCoord * 13),
								 (int)(312 - prevy - yCoord * 13), 
								 (int)(312 + x + xCoord * 13),
								 (int)(312 - y - yCoord * 13));
					
					// Lower Left
					g2d.drawLine((int)(312 - prevx + xCoord * 13),
								 (int)(312 + prevy - yCoord * 13), 
								 (int)(312 - x + xCoord * 13),
								 (int)(312 + y - yCoord * 13));
					
					// Upper Left
					g2d.drawLine((int)(312 - prevx + xCoord * 13),
								 (int)(312 - prevy - yCoord * 13), 
								 (int)(312 - x + xCoord * 13),
								 (int)(312 - y - yCoord * 13));
				}
			}
		}
	}
	
// GETTERS

	/* Returns x coordinate of vertex
	 * @return x coordinate of vertex
	 */
	public double getXCoord(){
		return xCoord;
	}
	
	/* Returns y coordinate of vertex
	 * @return y coordinate of vertex
	 */
	public double getYCoord(){
		return yCoord;
	}
	
	/* Returns horizontal distance
	 * @return horizontal distance
	 */
	public double getXDistance(){
		return xDistance;
	}

	/* Returns vertical distance
	 * @return vertical distance
	 */
	public double getYDistance(){
		return yDistance;
	}
	
	/* Returns direction of opening
	 * @return direction of opening
	 */
	public int getDirection(){
		return direction;
	}
	
}
