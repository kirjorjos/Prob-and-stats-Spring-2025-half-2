package PlotterAndSalter;

public class Coordinate {
	private double x;
	private double y;

	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public Coordinate clone() {
		return new Coordinate(x, y);
	}
}
