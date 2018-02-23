//Tussoun Jitpanyoyos #6088030 Section 1

public class Circle extends Shape {
	
	private double radius;
	
	public Circle() {
		
	}
	
	public Circle( String color, double radius) {
		super(color);
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return 2 * Math.PI * radius;
	}
	
	public double getArea(double radius) {
		this.radius = radius;
		return getArea();
	}
	
	@Override
	public String toString() {
		return "Circle[radius=" + radius + ", Shape[color=" + super.getColor() + "]]";
	}
}
