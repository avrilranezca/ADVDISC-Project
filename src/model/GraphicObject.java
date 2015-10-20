package model;

public abstract class GraphicObject {
	
	public abstract void translate(int height, int width);
	public abstract void rotate(double angle);
	public abstract void reflectOverX();
	public abstract void reflectOverY();
	public abstract void rescaleX(double percentage);
	public abstract void rescaleY(double percentage);
	public abstract void shearX(double angle);
	public abstract void shearY(double angle);
}
