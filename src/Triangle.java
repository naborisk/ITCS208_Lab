//Tussoun Jitpanyoyos #6088030 Section 1

/*  The structure of Triangle class is similar to Rectangle */
public class Triangle extends Shape {

	private double base;
	private double height;
	
   public Triangle() {
	   
   }
   
   public Triangle(String color, double base, double height) {
	   super(color);
	   this.base = base;
	   this.height = height;
   }
   
   public Triangle(double base, double height) {
	   this.base = base;
	   this.height = height;
   }
   
   @Override
   public double getArea() {
	   return 0.5 * base * height;
   }
   
   public double getArea(double base, double height) {
	   this.base = base;
	   this.height = height;
	   return getArea();
   }
   

   
   @Override
   public String toString() {
	   return "Triangle[base=" + base + ", height=" + height + "Shape[color=" + super.getColor() + "]]";
   }
}
