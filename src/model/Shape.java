package model;

public abstract class Shape {
	
	public abstract void translate(int height, int width);
	public abstract void rotate(double angle);
	public abstract void reflectOverX();
	public abstract void reflectOverY();
}
