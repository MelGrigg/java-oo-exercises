package classes;

public class Rectangle {
	
	private Integer length, width;
	
	public Rectangle(Integer length, Integer width) {
		this.length = length;
		this.width = width;
	}
	
	public Integer getArea() {
		return this.length * this.width;
	}
	
	public Integer getPerimeter() {
		return (this.length * 2) + (this.width * 2);
	}
	
	public boolean isSquare() {
		if (this.length == this.width)
			return true;
		return false;
	}
	
	public Integer getLength() {
		return this.length;
	}
	
	public Integer getWidth() {
		return this.width;
	}
	
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(2, 3);
		System.out.println("R1 Length: " + r1.getLength());
		System.out.println("R1 Width:  " + r1.getWidth());
		System.out.println("R1 Area:   " + r1.getArea());
		System.out.println("R1 Perim:  " + r1.getPerimeter());
		System.out.println("Square?    " + r1.isSquare());
		Rectangle r2 = new Rectangle(2, 2);
		System.out.println("R2 Square? " + r2.isSquare());
	}

}
