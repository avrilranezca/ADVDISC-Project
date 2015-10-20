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
		head.setX(head.getX() + width);
		head.setY(head.getY() + height);
		
		tail.setX(tail.getX() + width);
		tail.setY(tail.getY() + height);
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
		
		double newX = head.getX() * Math.cos(angle) - head.getY() * Math.sin(angle);
		double newY = head.getX() * Math.sin(angle) + head.getY() * Math.cos(angle);
		
		head.setX(newX + center.getX());
		head.setY(newY + center.getY());
		
		tail.setX(tail.getX() - center.getX());
		tail.setY(tail.getY() - center.getY());
		
		newX = tail.getX() * Math.cos(angle) - tail.getY() * Math.sin(angle);
		newY = tail.getX() * Math.sin(angle) + tail.getY() * Math.cos(angle);
		
		tail.setX(newX + center.getX());
		tail.setY(newY + center.getY());
	}

	@Override
	public void reflectOverX() {
		// TODO Auto-generated method stub
		head.setY(-head.getY());
		tail.setY(-tail.getY());
	}

	@Override
	public void reflectOverY() {
		// TODO Auto-generated method stub
		head.setX(-head.getX());
		tail.setX(-tail.getX());
	}

	@Override
	public void rescaleX(double percentage) {
		// TODO Auto-generated method stub
		head.setX(head.getX() * percentage);
		tail.setX(tail.getX() * percentage);
	}

	@Override
	public void rescaleY(double percentage) {
		// TODO Auto-generated method stub
		head.setY(head.getY() * percentage);
		tail.setY(tail.getY() * percentage);
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
