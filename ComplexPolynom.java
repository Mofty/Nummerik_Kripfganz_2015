
public class ComplexPolynom implements ComplexFunction {

	@Override
	public Complex apply(Complex c) {
		Complex p = new Complex(1, 0);
		Complex result = new Complex(0, 0);
		for (int i = 0; i < n; i++) {
			result = Complex.sum(result,
					Complex.mult(p, new Complex(coefficients[n - 1 - i], 0)));
			p = Complex.mult(p, c);
		}
		return result;
	}

	public ComplexPolynom(double[] coefficients) {
		this.coefficients = coefficients.clone();
		n = coefficients.length;
	}
	
	public static double[] derivateCoefficients(double[] coeff) {
		double[] result = new double[coeff.length - 1];
		for (int i = 1; i < coeff.length; i++) {
			result[coeff.length - 1 - i] = coeff[coeff.length - 1 - i] * i;
		}
		return result;
	}
	
	@Override
	public String toString() {
		String result = "0";
		for (int i = 0; i < n; i++) {
			result += " + " + coefficients[i] + " * x ^ " + (n - i - 1);
		}
		return result;
	}
	
	private double[] coefficients;
	private int n;
}
