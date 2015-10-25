package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class PolygonDrawer extends GraphicObject {
	
	double[][] points;
	
	public PolygonDrawer(double[][] p){
		points = p;
		isRed  = false;
	}
	
	public void paintObject(Graphics2D g2d) {
		GeneralPath polygon =  new GeneralPath(GeneralPath.WIND_EVEN_ODD,
											   points.length);
		
		polygon.moveTo(312 + (points[0][0] * 13), 312 + (points[0][1] * -13));

		for (int index = 1; index < points.length; index++) {
		        polygon.lineTo(312 + (points[index][0] * 13),
		        			   312 + (points[index][1] * -13));
		};

		polygon.closePath();
		
		g2d.draw(polygon);
	}
	
// GETTERS
	
	public double getXCoord(int index){
		return points[index][0];
	}
	
	public double getYCoord(int index){
		return points[index][1];
	}
	
	public int getPointCount(){
		return points.length;
	}
}
