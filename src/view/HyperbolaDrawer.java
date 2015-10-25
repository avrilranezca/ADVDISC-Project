package view;

import java.awt.Graphics2D;

public class HyperbolaDrawer extends GraphicObject {

	double xCoord;
	double yCoord;
	double xDistance;
	double yDistance;
	int    direction;
	
	public HyperbolaDrawer(double x, double y, double xd, double yd, int d, boolean r){
		xCoord      = x;
		yCoord      = y;
		xDistance   = xd;
		yDistance   = yd;
		direction   = d;
		isRed       = r;
	}
	
	public void paintObject(Graphics2D g2d) {
		if(direction == 1){
			double y = 0;
			double prevy;
			double prevx;
			
			for(int x=0;x<=500;x++){
				
				if(x == 0){
					y  = (yDistance * 13 * Math.sqrt(Math.pow((x - xCoord * 13)/(xDistance * 13), 2) - 1));
					prevy = y;
					prevx = x;
				}
				else{
					prevy = y;
					prevx = x - 1;
		            y = (yDistance * 13 * Math.sqrt(Math.pow((x - xCoord * 13)/(xDistance * 13), 2) - 1));
		            if(Double.isNaN(prevy)){
						prevy = y;
						prevx = x;
					}
				}
				
				if(!Double.isNaN(y) && !Double.isNaN(x)){
					// Lower Right
					g2d.drawLine((int)(312 + prevx),
								 (int)(312 + prevy - yCoord * 13), 
								 (int)(312 + x),
								 (int)(312 + y - yCoord * 13));
					
					// Upper Right
					g2d.drawLine((int)(312 + prevx),
								 (int)(312 - prevy - yCoord * 13), 
								 (int)(312 + x),
								 (int)(312 - y - yCoord * 13));
					
					// Lower Left
					g2d.drawLine((int)(312 - prevx + xCoord * 26),
								 (int)(312 + prevy - yCoord * 13), 
								 (int)(312 - x + xCoord * 26),
								 (int)(312 + y - yCoord * 13));
					
					// Upper Left
					g2d.drawLine((int)(312 - prevx + xCoord * 26),
								 (int)(312 - prevy - yCoord * 13), 
								 (int)(312 - x + xCoord * 26),
								 (int)(312 - y - yCoord * 13));
				}
			}
		}
		if(direction == 2){
			double y = 0;
			double prevy;
			double prevx;
			
			for(int x=0;x<=500;x++){
				if(x == 0){
		            y = (yDistance * 13 * Math.sqrt(Math.pow((x - xCoord * 13)/(xDistance * 13), 2) + 1));
					prevy = y;
					prevx = x;
				}
				else{
					prevx = x - 1;
					prevy = y;
		            y = (yDistance * 13 * Math.sqrt(Math.pow((x - xCoord * 13)/(xDistance * 13), 2) + 1));
//		            x = (xDistance * 13 * Math.sqrt(Math.pow((y - yCoord * 13)/(yDistance * 13), 2) + 1) + xCoord * 13);
		            if(Double.isNaN(prevy)){
						prevy = y;
						prevx = x;
					}
				}
				
				if(!Double.isNaN(y) && !Double.isNaN(x)){
					
					// Lower Right
					g2d.drawLine((int)(312 + prevx),
				   			 	 (int)(312 - yCoord * 13 + prevy),
				   			 	 (int)(312 + x),
				   			 	 (int)(312 - yCoord * 13 + y));
					
					// Upper Right
					g2d.drawLine((int)(312 + prevx),
				   			 	 (int)(312 - yCoord * 13 - prevy),
				   			 	 (int)(312 + x),
				   			 	 (int)(312 - yCoord * 13 - y));
					
					// Lower Left
					g2d.drawLine((int)(312 - prevx + xCoord * 26),
				   			 	 (int)(312 - yCoord * 13 + prevy),
				   			 	 (int)(312 - x + xCoord * 26),
				   			 	 (int)(312 - yCoord * 13 + y));
					
					// Upper Left
					g2d.drawLine((int)(312 - prevx + xCoord * 26),
				   			 	 (int)(312 - yCoord * 13 - prevy),
				   			 	 (int)(312 - x + xCoord * 26),
				   			 	 (int)(312 - yCoord * 13 - y));
				}
			}
		}
	}
	
// GETTERS

	public double getXCoord(){
		return xCoord;
	}
	
	public double getYCoord(){
		return yCoord;
	}
	
	public double getXDistance(){
		return xDistance;
	}
	
	public double getYDistance(){
		return yDistance;
	}
	
	public int getDirection(){
		return direction;
		
	}
		
	
}
