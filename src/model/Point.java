package model;

public class Point extends GraphicObject{

	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public void translate(int height, int width) {
		// TODO Auto-generated method stub
		x += width;
		y += height;
	}

	@Override
	public void rotate(double angle) {
		// TODO Auto-generated method stub
		double newX = x * Math.cos(angle) - y * Math.sin(angle);
		double newY = x * Math.sin(angle) + y * Math.cos(angle);
		
		x = newX;
		y = newY;
	}

	@Override
	public void reflectOverX() {
		// TODO Auto-generated method stub
		y = -y;
	}

	@Override
	public void reflectOverY() {
		// TODO Auto-generated method stub
		x = -x;
	}

	@Override
	public void rescaleX(double percentage) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void rescaleY(double percentage) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void shearX(double angle) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void shearY(double angle) {
		// TODO Auto-generated method stub
		return;
	}

}
