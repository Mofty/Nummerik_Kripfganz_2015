

public class Main {

	public static void main(String[] args) throws Exception {
//		aufg4();
		aufg3();
	}
	public static void aufg3() throws Exception {

		Complex c = Complex.sin(new Complex(2, 1.3));
		ComplexFunction f = new ComplexFunction() {
			@Override
			public Complex apply(Complex x) {
				return Complex.sum(Complex.sin(x), x);
			}
		};
		ComplexFunction fDeriv = new ComplexFunction() {
			@Override
			public Complex apply(Complex c) {
				return Complex.sum(Complex.cos(c), new Complex(1, 0));
			}
		};
		ComplexFunction fDeriv2 = new ComplexFunction() {
			@Override
			public Complex apply(Complex c) {
				return Complex.mult(new Complex(-1, 0), Complex.sin(c));
			}
		};

		Complex root =
				Newton.approximateRoot(f, fDeriv, fDeriv2, new Complex(4, 2),
						15, true);

		System.out.println("root = " + root);
	}

	public static void aufg4() throws Exception {
		double[] coefficients =
		{ 2.46488, 2.17212, -0.503487, -4.15984, -8.33233, 5.94108 };
		ComplexPolynom polynom = new ComplexPolynom(coefficients);
		ComplexPolynom pd = new ComplexPolynom(
				ComplexPolynom.derivateCoefficients(coefficients));
		System.out.println(pd);
		Complex[] startValues = {
				new Complex(2, 0),
				new Complex(0, 0),
				new Complex(-2, 0),
				new Complex(0, 10),
				new Complex(0, -10)
		};
		for (Complex startValue : startValues) {
			Complex root =
					Newton.approximateRoot(polynom, pd, null, startValue, 15,
							false);
			System.out.println(root);
		}
	}
}
