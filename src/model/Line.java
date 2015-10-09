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
		
	}
}
