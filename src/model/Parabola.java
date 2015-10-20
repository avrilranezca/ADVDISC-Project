package model;

public class Parabola extends GraphicObject{
	
	private Point vertex;
	private Point focus;
	private String directrixAxis;
	private double directrixValue;
	
	public Parabola(Point vertex, Point focus, String directrixAxis, double directrixValue) {
		this.vertex = vertex;
		this.focus = focus;
		this.directrixAxis = directrixAxis;
		this.directrixValue = directrixValue;
	}
	
	public Point getVertex() {
		return vertex;
	}
	
	public void setVertex(Point vertex) {
		this.vertex = vertex;
	}
	
	public Point getFocus() {
		return focus;
	}

	public void setFocus(Point focus) {
		this.focus = focus;
	}

	public String getDirectrixAxis() {
		return directrixAxis;
	}

	public void setDirectrixAxis(String directrixAxis) {
		this.directrixAxis = directrixAxis;
	}

	public double getDirectrixValue() {
		return directrixValue;
	}

	public void setDirectrixValue(double directrixValue) {
		this.directrixValue = directrixValue;
	}

	
	@Override
	public void translate(int height, int width) {
		// TODO Auto-generated method stub
		
		vertex.setX(vertex.getX() + width);
		vertex.setY(vertex.getY() + height);
		
		focus.setX(focus.getX() + width);
		focus.setY(focus.getY() + height);
		
		if(directrixAxis.equals("y")) {
			directrixValue += height;
		}
		else if(directrixAxis.equals("x")) {
			directrixValue += width;
		}
	}

	@Override
	public void rotate(double angle) {
		// TODO Auto-generated method stub
		
		vertex.setX(vertex.getX() * Math.cos(angle) - vertex.getY() * Math.sin(angle));
		vertex.setY(vertex.getX() * Math.sin(angle) + vertex.getY() * Math.cos(angle));
		
		focus.setX(focus.getX() * Math.cos(angle) - focus.getY() * Math.sin(angle));
		focus.setY(focus.getX() * Math.sin(angle) + focus.getY() * Math.cos(angle));
		
		/*
		 * Directrix manipulation here
		 */
	}

	@Override
	public void reflectOverX() {
		// TODO Auto-generated method stub
		
		vertex.setY(-vertex.getY());
		focus.setY(-focus.getY());
		
		directrixValue = -directrixValue;
	}

	@Override
	public void reflectOverY() {
		// TODO Auto-generated method stub
		
		vertex.setX(-vertex.getX());
		focus.setY(-vertex.getY());
		
		directrixValue = -directrixValue;
	}

	@Override
	public void rescaleX(double percentage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rescaleY(double percentage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shearX(double angle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shearY(double angle) {
		// TODO Auto-generated method stub
		
	}

}
