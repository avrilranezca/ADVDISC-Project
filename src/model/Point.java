package model;

public class Point extends Shape {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = x;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public void translate(int height, int width) {
		// TODO Auto-generated method stub
		
		this.x = width;
		this.y = height;
		
	}

	@Override
	public void rotate(double angle) {
		// TODO Auto-generated method stub
		
	}

}
