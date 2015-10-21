package model;

public class Line extends GraphicObject{

	private Point head;
	private Point tail;

	public Line(Point head, Point tail) {
		this.head = head;
		this.tail = tail;
	}

	public Point getHead() {
		return head;
	}

	public void setHead(Point head) {
		this.head = head;
	}

	public Point getTail() {
		return tail;
	}

	public void setTail(Point tail) {
		this.tail = tail;
	}

	@Override
	public void translate(int height, int width) {
		// TODO Auto-generated method stub
		head.translate(height, width);
		tail.translate(height, width);
	}

	@Override
	public void rotate(double angle) {
		// TODO Auto-generated method stub
		/*if(angle%90 == 0) {
			while(angle < 0) {
				angle += 360;
			}
			
			while(angle > 0) {
				double tempX;
				double tempY;
				
				tempX = head.getX();
				tempY = head.getY();
				
				head.setX(-tempY);
				head.setY(tempX);
				
				tempX = tail.getX();
				tempY = tail.getY();
				
				tail.setX(-tempY);
				tail.setY(tempX);
				
				angle -= 90;
			}
		}*/
		Point center = new Point((head.getX()+tail.getX())/2, (head.getY()+tail.getY())/2);
		
		head.setX(head.getX() - center.getX());
		head.setY(head.getY() - center.getY());
		
		head.rotate(angle);
		
		head.setX(head.getX() + center.getX());
		head.setY(head.getY() + center.getY());
		
		tail.setX(tail.getX() - center.getX());
		tail.setY(tail.getY() - center.getY());
		
		tail.rotate(angle);
		
		tail.setX(tail.getX() + center.getX());
		tail.setY(tail.getY() + center.getY());
	}

	@Override
	public void reflectOverX() {
		// TODO Auto-generated method stub
		head.reflectOverX();
		tail.reflectOverX();
	}

	@Override
	public void reflectOverY() {
		// TODO Auto-generated method stub
		head.reflectOverY();
		tail.reflectOverY();
	}

	@Override
	public void rescaleX(double percentage) {
		// TODO Auto-generated method stub
		head.rescaleX(percentage);
		tail.rescaleX(percentage);
	}

	@Override
	public void rescaleY(double percentage) {
		// TODO Auto-generated method stub
		head.rescaleY(percentage);
		tail.rescaleY(percentage);
	}

	@Override
	public void shearX(double angle) {
		// TODO Auto-generated method stub
		head.shearX(angle);
		tail.shearX(angle);
	}

	@Override
	public void shearY(double angle) {
		// TODO Auto-generated method stub
		head.shearY(angle);
		tail.shearY(angle);
	}
}
