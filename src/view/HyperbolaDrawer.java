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
		if(direction == 2){
			double x = 0;
			double prevy;
			double prevx;
			
			for(int y=0;y<=500;y++){
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
		
// TOSTRING
	
	public String toString(){
		return "\nHyperbolaDrawer - - - - - - - - - - - - - - - - - - - -" +
			   "\nxCoord: " + xCoord +
			   "\nyCoord: " + yCoord +
			   "\nxDistance: " + xDistance +
			   "\nyDistance: " + yDistance +
			   "\nDirection: " + MainView.getHDirectionString(direction) +
			   "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
	}
	
}
