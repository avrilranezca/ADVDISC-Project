package model;

public class Line extends Shape{

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
		if(angle%90 == 0) {
			while(angle < 0) {
				angle += 360;
			}
			
			while(angle > 0) {
				int tempX;
				int tempY;
				
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
		}
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
		head.setX((int)Math.round(head.getX() * percentage));
		tail.setX((int)Math.round(tail.getX() * percentage));
	}

	@Override
	public void rescaleY(double percentage) {
		// TODO Auto-generated method stub
		head.setY((int)Math.round(head.getY() * percentage));
		tail.setY((int)Math.round(tail.getY() * percentage));
	}
}
