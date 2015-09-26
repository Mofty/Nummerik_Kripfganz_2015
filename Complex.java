
public class Complex {

	double real;
	double imag;

	public double getReal() {
		return real;
	}
	public double getImag() {
		return imag;
	}
	
	@Override
	public String toString() {
		return "(" + real + " + i * " + imag + ")";
	}

	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public static Complex sum(Complex a, Complex b) {
		return new Complex(a.real + b.real, a.imag + b.imag);
	}
	public static Complex subtr(Complex a, Complex b) {
		return new Complex(a.real - b.real, a.imag - b.imag);
	}

	public static Complex mult(Complex a, Complex b) {
		return new Complex(a.real * b.real - a.imag * b.imag,
				a.real * b.imag + a.imag * b.real);
	}
	public static Complex div(Complex a, Complex b) {
		double d = b.real * b.real + b.imag * b.imag;
		return new Complex((a.real * b.real + a.imag * b.imag) / d,
				(a.imag * b.real - a.real * b.imag) / d);
	}
	public static Complex pow(double base, Complex exponent) {
		double f = Math.pow(base, exponent.real);
		double g = Math.log(base) * exponent.imag;
		return new Complex(f * Math.cos(g), f * Math.sin(g));
	}
	public static Complex exp(Complex exponent) {
		double f = Math.exp(exponent.real);
		double g = exponent.imag;
		return new Complex(f * Math.cos(g), f * Math.sin(g));
	}
	public static Complex sin(Complex a) {
		return div(
				subtr(
						exp(mult(
								getI(),
								a)),
						exp(mult(
								new Complex(0, -1),
								a))),
				new Complex(0, 2));
	}
	public static Complex cos(Complex a) {
		return div(
				sum(
						exp(mult(
								getI(),
								a)),
						exp(mult(
								new Complex(0, -1),
								a))),
				new Complex(2, 0));
	}

	public static Complex getI() {
		return i;
	}
	
	public static Complex zero() {
		return nichts;
	}

	public static Complex fromReal(double r) {
		return new Complex(r, 0);
	}
	public static double abs(Complex c) {
		return c.real * c.real + c.imag * c.imag; 
	}

	private static Complex i = new Complex(0, 1);

	private static Complex nichts = new Complex(0, 0);
}
