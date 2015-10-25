package view;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.QuadCurve2D;
import java.math.*;

public class ParabolaDrawer extends GraphicObject {

	double xCoord;      // x coordinate of vertex
	double yCoord;      // y coordinate of vertex
	double focalLength; // focal length
	int    direction;   // direction of opening
	
	/* Constructor
	 * @param x x coordinate of vertex
	 * @param y y coordinate of vertex
	 * @param f focal length
	 * @param d direction of opening
	 */
	public ParabolaDrawer(double x, double y, double f, int d){
		xCoord      = x;
		yCoord      = y;
		focalLength = f;
		direction   = d;
		isRed       = false;
	}
	
	/* Draws parabola
	 * @param g2d Graphics2D object
	 */
	public void paintObject(Graphics2D g2d) {
		double x     = 0;
		double y     = 0;
		double prevy = 0;
		double prevx = 0;
		
		// If horizontal opening
		if(direction == MainView.PARABOLA_RIGHT
		   || direction == MainView.PARABOLA_LEFT){
				
	        for(x = 0; x < 624; x++){
	        	
	        	if(x != 0){
	        		prevx = x - 1;
					prevy = y;
	        	}
	        	
	        	y = Math.sqrt(4 * focalLength * x * 13);
	        	
	        	if(x == 0){
	        		prevy = y;
	        		prevx = x;
	        	}
	        	
	        	if(Double.isNaN(prevy)){
					prevy = y;
					prevx = x;
				}
	            
	            // If opening to the right
	            if(direction == MainView.PARABOLA_RIGHT
	               && !Double.isNaN(y) && !Double.isNaN(x)){

		            g2d.drawLine((int)((312 + (xCoord * 13)) + prevx),
		            			 (int)((312 + (yCoord * -13)) - prevy),
		            			 (int)((312 + (xCoord * 13)) + x),
		            			 (int)((312 + (yCoord * -13)) - y));
		            
		            g2d.drawLine((int)((312 + (xCoord * 13)) + prevx),
		            			 (int)((312 + (yCoord * -13)) + prevy),
		            			 (int)((312 + (xCoord * 13)) + x),
		            			 (int)((312 + (yCoord * -13)) + y));
			    }
			            
			    // If opening to the left
		        else if(direction == MainView.PARABOLA_LEFT
		        		&& !Double.isNaN(y) && !Double.isNaN(x)){
	            		
	            	g2d.drawLine((int)((312 + (xCoord * 13)) - prevx),
	            			     (int)((312 + (yCoord * -13)) - prevy),
		            			 (int)((312 + (xCoord * 13)) - x),
		            			 (int)((312 + (yCoord * -13)) - y));
	            	
		            g2d.drawLine((int)((312 + (xCoord * 13)) - prevx),
		            		     (int)((312 + (yCoord * -13)) + prevy),
		            		     (int)((312 + (xCoord * 13)) - x),
		            		     (int)((312 + (yCoord * -13)) + y));
			    }
		    }
		}
		
		// If vertical opening
		else if(direction == MainView.PARABOLA_UP
				|| direction == MainView.PARABOLA_DOWN){
			
	        for(y = 0; y < 624; y++){
	        	
	        	if(y != 0){
	        		prevx = x;
					prevy = y - 1;
	        	}
	        	
	        	x = Math.sqrt(4 * focalLength * y * 13);
	        	
	        	if(y == 0){
	        		prevy = y;
	        		prevx = x;
	        	}
	        	
	        	if(Double.isNaN(prevx)){
					prevy = y;
					prevx = x;
				}
	            
	            // If opening upwards
	            if(direction == MainView.PARABOLA_UP
	               && !Double.isNaN(y) && !Double.isNaN(x)){
		            g2d.drawLine((int)((312 + (xCoord * 13)) + prevx),
		            			 (int)((312 + (yCoord * -13)) - prevy),
		            			 (int)((312 + (xCoord * 13)) + x),
		            			 (int)((312 + (yCoord * -13)) - y));
		            
		            g2d.drawLine((int)((312 + (xCoord * 13)) - prevx),
		            			 (int)((312 + (yCoord * -13)) - prevy),
		            			 (int)((312 + (xCoord * 13)) - x),
		            			 (int)((312 + (yCoord * -13)) - y));
			    }
			        
			    // if opening downwards    
		        else if(direction == MainView.PARABOLA_DOWN
	            	    && !Double.isNaN(y) && !Double.isNaN(x)){
		            	
	            	g2d.drawLine((int)((312 + (xCoord * 13)) + prevx),
	            			     (int)((312 + (yCoord * -13)) + prevy),
		            			 (int)((312 + (xCoord * 13)) + x),
		            			 (int)((312 + (yCoord * -13)) + y));
	            	
		            g2d.drawLine((int)((312 + (xCoord * 13)) - prevx),
		            		     (int)((312 + (yCoord * -13)) + prevy),
		            		     (int)((312 + (xCoord * 13)) - x),
		            		     (int)((312 + (yCoord * -13)) + y));
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
	
	/* Returns focal length
	 * @return focal length
	 */
	public double getFocalLength(){
		return focalLength;
	}
	
	/* Returns direction of opening
	 * @return direction of opening
	 */
	public int getDirection(){
		return direction;
		
	}
	
}
