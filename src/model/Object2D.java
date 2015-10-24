package model;

public abstract class Object2D {
	
	public abstract void translate(double height, double width);
	public abstract void rotate(double angle);
	public abstract void reflectOverX();
	public abstract void reflectOverY();
	public abstract void rescaleX(double percentage);
	public abstract void rescaleY(double percentage);
	public abstract void shearX(double angle);
	public abstract void shearY(double angle);
}
