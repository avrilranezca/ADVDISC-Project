package model;

public class Point extends Object2D{

	private double coordinates[][];

	public Point(double x, double y) {
		coordinates = new double[3][1];
		coordinates[0][0] = x;
		coordinates[1][0] = y;
		coordinates[2][0] = 1;
	}

	public double getX() {
		return coordinates[0][0];
	}

	public double getY() {
		return coordinates[1][0];
	}

	public void setX(double x) {
		coordinates[0][0] = x;
	}

	public void setY(double y) {
		coordinates[1][0] = y;
	}

	public String toString() {
		return "(" + coordinates[0][0] + "," + coordinates[1][0] + ")";
	}

	@Override
	public void translate(double height, double width) {
		// TODO Auto-generated method stub
		double[][] translationMatrix = new double[coordinates.length][coordinates.length];
		for(int i = 0; i < translationMatrix.length; i++) {
			for(int j = 0; j < translationMatrix[i].length; j++) {
				if(i == j) {
					translationMatrix[i][j] = 1;
				}
			}
		}
		translationMatrix[0][coordinates.length-1] = width;
		translationMatrix[1][coordinates.length-1] = height;
		coordinates = Matrix.multiply(translationMatrix, coordinates);
	}

	@Override
	public void rotate(double angle) {
		// TODO Auto-generated method stub
		angle = Math.toRadians(angle);
		double rotationMatrix[][] = {{Math.cos(Math.toRadians(angle)), -Math.sin(Math.toRadians(angle)), 0}, 
									{Math.sin(Math.toRadians(angle)), Math.cos(Math.toRadians(angle)), 0}};
		coordinates = Matrix.multiply(rotationMatrix, coordinates);
	}

	@Override
	public void reflectOverX() {
		// TODO Auto-generated method stub
		double reflectionMatrix[][] = {{1, 0, 0},
									{0, -1, 0},
									{0, 0, 1}};
		coordinates = Matrix.multiply(reflectionMatrix, coordinates);
	}

	@Override
	public void reflectOverY() {
		// TODO Auto-generated method stub
		double reflectionMatrix[][] = {{-1, 0, 0},
									{0, 1, 0},
									{0, 0, 1}};
		coordinates = Matrix.multiply(reflectionMatrix, coordinates);
	}

	@Override
	public void rescaleX(double percentage) {
		// TODO Auto-generated method stub
		double rescalingMatrix[][] = new double[coordinates.length][coordinates.length];
		
		for(int i = 0; i < rescalingMatrix.length; i++) {
			for(int j = 0; j < rescalingMatrix[i].length; j++) {
				if(i == j) {
					rescalingMatrix[i][j] = 1;
				}
			}
		}
		
		rescalingMatrix[0][0] = percentage;
		coordinates = Matrix.multiply(rescalingMatrix, coordinates);
	}

	@Override
	public void rescaleY(double percentage) {
		// TODO Auto-generated method stub
		double rescalingMatrix[][] = new double[coordinates.length][coordinates.length];
		
		for(int i = 0; i < rescalingMatrix.length; i++) {
			for(int j = 0; j < rescalingMatrix[i].length; j++) {
				if(i == j) {
					rescalingMatrix[i][j] = 1;
				}
			}
		}
		
		rescalingMatrix[1][1] = percentage;
		coordinates = Matrix.multiply(rescalingMatrix, coordinates);
	}

	@Override
	public void shearX(double angle) {
		// TODO Auto-generated method stub
		double shearingMatrix[][] = new double[coordinates.length][coordinates.length];
		for(int i = 0; i < shearingMatrix.length; i++) {
			for(int j = 0; j < shearingMatrix[i].length; j++) {
				if(i == j) {
					shearingMatrix[i][j] = 1;
				}
			}
		}
		
		shearingMatrix[0][1] = Math.tan(angle);
		coordinates = Matrix.multiply(shearingMatrix, coordinates);
	}

	@Override
	public void shearY(double angle) {
		// TODO Auto-generated method stub
		double shearingMatrix[][] = new double[coordinates.length][coordinates.length];
		for(int i = 0; i < shearingMatrix.length; i++) {
			for(int j = 0; j < shearingMatrix[i].length; j++) {
				if(i == j) {
					shearingMatrix[i][j] = 1;
				}
			}
		}
		
		shearingMatrix[1][0] = Math.tan(angle);
		coordinates = Matrix.multiply(shearingMatrix, coordinates);
	}

}
