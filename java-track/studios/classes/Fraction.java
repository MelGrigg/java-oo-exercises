package classes;

public class Fraction {

	private Integer num, den;
	
	public Fraction(Integer num, Integer den) {
		this.num = num;
		this.den = den;
	}
	
	private Integer gcd(Integer x, Integer y) {
		if (y == 0) {
			return x;
		}
		return gcd(y, x % y);
	}
	
	public Fraction add(Fraction f) {
		Integer newNum = (this.num * f.getDen()) + (f.getNum() * this.den);
		Integer newDen = this.den * f.getDen();
		Fraction newFrac = new Fraction(newNum, newDen);
		return newFrac.simplify();
	}
	
	public Fraction mult(Fraction f) {
		Integer newNum = this.num * f.getNum();
		Integer newDen = this.den * f.getDen();
		Fraction newFrac = new Fraction(newNum, newDen);
		return newFrac.simplify();
	}
	
	public Fraction recip() {
		return new Fraction(this.den, this.num);
	}
	
	public Fraction simplify() {
		Integer gcd = gcd(this.num, this.den);
		Integer newNum = this.num / gcd;
		Integer newDen = this.den / gcd;
		return new Fraction(newNum, newDen);
	}
	
	public Integer getNum() {
		return this.num;
	}
	
	public Integer getDen() {
		return this.den;
	}
	
	public String toString() {
		return this.num + "/" + this.den;
	}
	
	public static void main(String[] args) {
		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(1, 3);
		System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
		System.out.println(f1 + " * " + f2 + " = " + f1.mult(f2));
		Fraction f3 = new Fraction(4, 6);
		System.out.println(f3);
		System.out.println(f3.simplify());
	}

}
