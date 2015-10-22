package model;

public class Ellipse extends GraphicObject{

	private Point center;
	private double width;
	private double height;
	
	public Ellipse(Point center, double height, double width) {
		this.center = center;
		this.height = height;
		this.width = width;
	}
	
	@Override
	public void translate(int height, int width) {
		// TODO Auto-generated method stub
		center.translate(height, width);
	}

	@Override
	public void rotate(double angle) {
		// TODO Auto-generated method stub
		if(angle%90 == 0) {
			while(angle < 0) {
				angle += 360;
			}
			
			while(angle > 360) {
				angle -= 360;
			}
			
			if(angle == 90 || angle == 270) {
				double temp = width;
				width = height;
				height = temp;
			}
		}
	}

	@Override
	public void reflectOverX() {
		// TODO Auto-generated method stub
		center.reflectOverY();
	}

	@Override
	public void reflectOverY() {
		// TODO Auto-generated method stub
		center.reflectOverX();
	}

	@Override
	public void rescaleX(double percentage) {
		// TODO Auto-generated method stub
		width *= percentage;
	}

	@Override
	public void rescaleY(double percentage) {
		// TODO Auto-generated method stub
		height *= percentage;
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
