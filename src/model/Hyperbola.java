package model;

public class Hyperbola extends GraphicObject{
	
	private Point center;
	private double horizontalDistance;
	private double verticalDistance;
	private int direction;
	
	public Hyperbola(Point center, double horizontalDistance, double verticalDistance, int direction) {
		this.center = center;
		this.horizontalDistance = horizontalDistance;
		this.verticalDistance = verticalDistance;
		this.direction = direction;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public double getHorizontalDistance() {
		return horizontalDistance;
	}
	
	public void setHorizontalDistance(double horizontalDistance) {
		this.horizontalDistance = horizontalDistance;
	}
	
	public double getVerticalDistance() {
		return verticalDistance;
	}
	
	public void setVerticalDistance(double verticalDistance) {
		this.verticalDistance = verticalDistance;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}

	@Override
	public void translate(int height, int width) {
		// TODO Auto-generated method stub
		
		center.translate(height, width);
		
	}

	@Override
	public void rotate(double angle) {
		// TODO Auto-generated method stub
		
		if(angle % 90 == 0) {
			
			while(angle < 0) {
				angle += 360;
			}
			
			while(angle > 360) {
				angle -= 360;
			}
			
			while(angle >= 90)
			{
				if(direction == 1) {
					direction = 2;
				}
				else if (direction == 2) {
					direction = 1;
				}
				
				double temp = horizontalDistance;
				horizontalDistance = verticalDistance;
				verticalDistance = temp;
				
				center.rotate(90);
				angle -= 90;
			}
		}
	}

	@Override
	public void reflectOverX() {
		// TODO Auto-generated method stub
		center.reflectOverX();
	}

	@Override
	public void reflectOverY() {
		// TODO Auto-generated method stub
		center.reflectOverY();
	}

	@Override
	public void rescaleX(double percentage) {
		// TODO Auto-generated method stub
		horizontalDistance *= percentage;
	}

	@Override
	public void rescaleY(double percentage) {
		// TODO Auto-generated method stub
		verticalDistance *= percentage;
		
	}

	@Override
	public void shearX(double angle) {
		// TODO Auto-generated method stub
		/* REALLY? */
	}

	@Override
	public void shearY(double angle) {
		// TODO Auto-generated method stub
		/* I CRY */
	}
	
	

}
