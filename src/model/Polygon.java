package model;

public class Polygon extends Object2D{

	private Point[] points;
	
	public Polygon(Point[] points) {
		this.points = points;
	}
	
	public Point[] getPoints() {
		return points;
	}
	
	@Override
	public void translate(double height, double width) {
		// TODO Auto-generated method stub
		for(Point point : points) {
			point.translate(height, width);
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
		System.out.println(this);
		double sumX = 0;
		double sumY = 0;
		
		for(Point point : points) {
			sumX += point.getX();
			sumY += point.getY();
		}
		
		Point center = new Point(sumX/points.length, sumY/points.length);
		System.out.println(center);
		for(Point point : points) {
			point.setX(point.getX() - center.getX());
			point.setY(point.getY() - center.getY());
			
			double newX = point.getX() * Math.cos(angle) - point.getY() * Math.sin(angle);
			double newY = point.getX() * Math.sin(angle) + point.getY() * Math.cos(angle);
			
			point.setX(newX + center.getX());
			point.setY(newY + center.getY());
		}
	}

	@Override
	public void reflectOverX() {
		// TODO Auto-generated method stub
		for(Point point : points) {
			point.reflectOverX();
		}
	}

	@Override
	public void reflectOverY() {
		// TODO Auto-generated method stub
		for(Point point : points) {
			point.reflectOverY();
		}
	}

	@Override
	public void rescaleX(double percentage) {
		// TODO Auto-generated method stub
		for(Point point : points) {
			point.setX(point.getX() * percentage);
		}
	}

	@Override
	public void rescaleY(double percentage) {
		// TODO Auto-generated method stub
		for(Point point : points) {
			point.setY(point.getY() * percentage);
		}
	}
	
	public String toString() {
		String pointList = "";
		for(Point point : points) {
			pointList += point + "\n";
		}
		return pointList;
	}

	@Override
	public void shearX(double angle) {
		// TODO Auto-generated method stub
		double minY = points[0].getY();
		
		for(int i = 1; i < points.length; i++) {
			if(points[i].getY() < minY) {
				minY = points[i].getY();
			}
		}
		
		for(Point point : points) {
			if(point.getY() > minY) {
				point.shearX(angle);
			}
		}
	}

	@Override
	public void shearY(double angle) {
		// TODO Auto-generated method stub
		double minX = points[0].getX();
		
		for(int i = 1; i < points.length; i++) {
			if(points[i].getX() < minX) {
				minX = points[i].getX();
			}
		}
		for(Point point : points) {
			if(point.getX() > minX) {
				point.shearY(angle);
			}
		}
	}

}
