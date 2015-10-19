package model;

public class Polygon extends GraphicObject{

	private Point[] points;
	
	public Polygon(Point[] points) {
		this.points = points;
	}
	
	@Override
	public void translate(int height, int width) {
		// TODO Auto-generated method stub
		for(Point point : points) {
			point.setX(point.getX() + width);
			point.setY(point.getY() + height);
		}
	}

	@Override
	public void rotate(double angle) {
		// TODO Auto-generated method stub
		/*if(angle%90 == 0) {
			while(angle < 0) {
				angle += 360;
			}
			double tempAngle;
			
			for(Point point : points) {
				tempAngle = angle;
				while(tempAngle > 0) {
					double tempX;
					double tempY;
					
					tempX = point.getX();
					tempY = point.getY();
					
					point.setX(-tempY);
					point.setY(tempX);
					
					tempAngle -= 90;
				}
			}
		}*/
		for(Point point : points) {
			double newX = point.getX() * Math.cos(angle) - point.getY() * Math.sin(angle);
			double newY = point.getX() * Math.sin(angle) + point.getY() * Math.cos(angle);
			
			point.setX(newX);
			point.setY(newY);
		}
	}

	@Override
	public void reflectOverX() {
		// TODO Auto-generated method stub
		for(Point point : points) {
			point.setY(-point.getY());
		}
	}

	@Override
	public void reflectOverY() {
		// TODO Auto-generated method stub
		for(Point point : points) {
			point.setX(-point.getX());
		}
	}

	@Override
	public void rescaleX(double percentage) {
		// TODO Auto-generated method stub
		for(Point point : points) {
			point.setX((int)Math.round(point.getX() * percentage));
		}
	}

	@Override
	public void rescaleY(double percentage) {
		// TODO Auto-generated method stub
		for(Point point : points) {
			point.setY((int)Math.round(point.getY() * percentage));
		}
	}

}
