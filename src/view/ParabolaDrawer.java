package view;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.QuadCurve2D;
import java.math.*;

public class ParabolaDrawer extends GraphicObject {

	double xCoord;
	double yCoord;
	double focalLength;
	int    direction;
	
	public ParabolaDrawer(double x, double y, double f, int d){
		xCoord      = x;
		yCoord      = y;
		focalLength = f;
		direction   = d;
		isRed       = false;
	}
	
	public void paintObject(Graphics2D g2d) {
		
		QuadCurve2D q = new QuadCurve2D.Float();
		
		double x = 0;
		double y = 0;
		double prevy = 0;
		double prevx = 0;
		
		switch(direction){
		
			case 1:
			case 2:
				
		        for(x=0;x<=500;x++){
		        	
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
		            
		            switch(direction){
			            case 1:
			            	
			            	if(!Double.isNaN(y) && !Double.isNaN(x)){
			            		
					            g2d.drawLine((int)((312 + (xCoord * 13)) + prevx),
					            			 (int)((312 + (yCoord * -13)) - prevy),
					            			 (int)((312 + (xCoord * 13)) + x),
					            			 (int)((312 + (yCoord * -13)) - y));
					            
					            g2d.drawLine((int)((312 + (xCoord * 13)) + prevx),
					            			 (int)((312 + (yCoord * -13)) + prevy),
					            			 (int)((312 + (xCoord * 13)) + x),
					            			 (int)((312 + (yCoord * -13)) + y));
					            
			            	}
				            
				            break;
				            
			            case 2:
			            	
			            	if(!Double.isNaN(y) && !Double.isNaN(x)){
			            		
				            	g2d.drawLine((int)((312 + (xCoord * 13)) - prevx),
				            			     (int)((312 + (yCoord * -13)) - prevy),
					            			 (int)((312 + (xCoord * 13)) - x),
					            			 (int)((312 + (yCoord * -13)) - y));
				            	
					            g2d.drawLine((int)((312 + (xCoord * 13)) - prevx),
					            		     (int)((312 + (yCoord * -13)) + prevy),
					            		     (int)((312 + (xCoord * 13)) - x),
					            		     (int)((312 + (yCoord * -13)) + y));
					            
			            	}
				            
				            break;
		            }
		            
		        }
		        
		        break;
		
		
			case 3:
			case 4:
				
		        for(y=0;y<=500;y++){
		        	
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
		            
		            switch(direction){
			            case 3:
			            	
				            g2d.drawLine((int)((312 + (xCoord * 13)) + prevx),
				            			 (int)((312 + (yCoord * -13)) - prevy),
				            			 (int)((312 + (xCoord * 13)) + x),
				            			 (int)((312 + (yCoord * -13)) - y));
				            
				            g2d.drawLine((int)((312 + (xCoord * 13)) - prevx),
				            			 (int)((312 + (yCoord * -13)) - prevy),
				            			 (int)((312 + (xCoord * 13)) - x),
				            			 (int)((312 + (yCoord * -13)) - y));
				    		
				            break;
				            
			            case 4:
			            	
			            	g2d.drawLine((int)((312 + (xCoord * 13)) + prevx),
			            			     (int)((312 + (yCoord * -13)) + prevy),
				            			 (int)((312 + (xCoord * 13)) + x),
				            			 (int)((312 + (yCoord * -13)) + y));
			            	
				            g2d.drawLine((int)((312 + (xCoord * 13)) - prevx),
				            		     (int)((312 + (yCoord * -13)) + prevy),
				            		     (int)((312 + (xCoord * 13)) - x),
				            		     (int)((312 + (yCoord * -13)) + y));
				            
				            break;
		            }
		        }
		        
		        break;
		        
		}
		
		g2d.draw(q);
	}
	
// GETTERS
	
	public double getXCoord(){
		return xCoord;
	}
	
	public double getYCoord(){
		return yCoord;
	}
	
	public double getFocalLength(){
		return focalLength;
	}
	
	public int getDirection(){
		return direction;
		
	}
	
}
