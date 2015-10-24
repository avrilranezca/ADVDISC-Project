package model;

public class Parabola extends Object2D{
	
	private Point vertex;
	private Point focus;
	private double focalLength;
	private int direction;
	//private ConicMatrix matrix;
		
	public Parabola(Point vertex, Point focus, double focalLength, int direction) {
		super();
		this.vertex = vertex;
		this.focus = focus;
		this.focalLength = focalLength;
		this.direction = direction;
		//matrix = new ConicMatrix();
		//convertToMatrix();
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

	public double getFocalLength() {
		return focalLength;
	}

	public void setFocalLength(double focalLength) {
		this.focalLength = focalLength;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/*public void convertToMatrix()
	{
		if(direction.equals("vertical"))
		{
			matrix.setA(1);
			matrix.setB(2);
			matrix.setC(0);
			matrix.setE(2 * (-vertex.getX()));
			matrix.setF(4 * focalLength * -1);
			matrix.setH(4 * focalLength * (-vertex.getY()) + (vertex.getX() * vertex.getX()) * -1);
		}
		
		//System.out.println(matrix);
	}*/

	@Override
	public void translate(double height, double width) {
		// TODO Auto-generated method stub
		
		vertex.translate(height, width);
		focus.translate(height, width);
	}

	@Override
	public void rotate(double angle) {
		// TODO Auto-generated method stub
		
		if(angle % 90 == 0) {
			
			while(angle < 0) {
				angle += 360;
			}
			
			while(angle > 360) {
				angle -= 360;
			}
			
			while(angle >= 90)
			{
				/* Opens upwards */
				if(vertex.getX() == focus.getX() && vertex.getY() < focus.getY()) {
					/*double temp = vertex.getX();
					vertex.setX(vertex.getY());
					vertex.setY(-temp);
					
					temp = focus.getX();
					focus.setX(focus.getY());
					vertex.setY(-temp);*/
					
					direction = 1;
				}
				/* Opens downwards */
				else if(vertex.getX() == focus.getX() && vertex.getY() > focus.getY()) {
					/*double temp = vertex.getX();
					vertex.setX(-vertex.getY());
					vertex.setY(temp);
					
					temp = focus.getX();
					focus.setX(-focus.getY());
					focus.setY(temp);*/
					
					direction = 2;
				}
				/* Opens to the right */
				else if(vertex.getY() == focus.getY() && vertex.getX() < focus.getX()) {
					/*double temp = vertex.getX();
					vertex.setX(-vertex.getY());
					vertex.setY(temp);
					
					temp = focus.getX();
					focus.setX(-focus.getY());
					focus.setY(temp);*/
					
					direction = 4;
				}
				/* Opens to the left */
				else if(vertex.getY() == focus.getY() && vertex.getX() > focus.getY()) {
					/*double temp = vertex.getX();
					vertex.setX(-vertex.getY());
					vertex.setY(temp);
					
					temp = focus.getX();
					focus.setX(-focus.getY());
					focus.setY(temp);*/
					
					direction = 3;
				}
				
				vertex.rotate(90);
				focus.rotate(90);
				
				angle -= 90;
			}
		}
		
	}

	@Override
	public void reflectOverX() {
		// TODO Auto-generated method stub
		
		/*vertex.setY(-vertex.getY());
		focus.setY(-focus.getY());*/
		
		/*directrixValue = -directrixValue;*/
		
		vertex.reflectOverX();
		focus.reflectOverX();
	}

	@Override
	public void reflectOverY() {
		// TODO Auto-generated method stub
		
		/*vertex.setX(-vertex.getX());
		focus.setY(-vertex.getY());*/
		
		/*directrixValue = -directrixValue;*/
		
		vertex.reflectOverY();
		focus.reflectOverY();
	}

	@Override
	public void rescaleX(double percentage) {
		// TODO Auto-generated method stub
		
		focalLength *= percentage;
	}

	@Override
	public void rescaleY(double percentage) {
		// TODO Auto-generated method stub
		
		focalLength *= percentage;
	}

	@Override
	public void shearX(double angle) {
		// TODO Auto-generated method stub
		
		/* POSIBLE BA ITO */
	}

	@Override
	public void shearY(double angle) {
		// TODO Auto-generated method stub
		
		/* POSIBLE BA ITO */
	}

}
