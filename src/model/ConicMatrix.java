package model;

public class ConicMatrix {
	
	private double A;
	private double B;
	private double C;
	private double E;
	private double F;
	private double H;
	
	public ConicMatrix() {
		A = 0;
		B = 0;
		C = 0;
		E = 0;
		F = 0;
		H = 0;
	}
	
	public ConicMatrix(double a, double b, double c, double e, double f,
			double h) {
		super();
		A = a;
		B = b;
		C = c;
		E = e;
		F = f;
		H = h;
	}

	public double getA() {
		return A;
	}

	public void setA(double a) {
		A = a;
	}

	public double getB() {
		return B;
	}

	public void setB(double b) {
		B = b;
	}

	public double getC() {
		return C;
	}

	public void setC(double c) {
		C = c;
	}

	public double getE() {
		return E;
	}

	public void setE(double e) {
		E = e;
	}

	public double getF() {
		return F;
	}

	public void setF(double f) {
		F = f;
	}

	public double getH() {
		return H;
	}

	public void setH(double h) {
		H = h;
	}
	
	public String toString() {
		return "A: " + A + " B: " + B + " C: " + C + " E: " + E + " F: " + F + " H: " + H;
	}
	
}
