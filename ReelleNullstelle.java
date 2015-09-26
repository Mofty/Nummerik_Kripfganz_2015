
public class ReelleNullstelle {
	public static Complex getRoot(Complex start, double precision, int iterations, Polynom poly) throws InternalError {
		Polynom ableitung = Ableitung.getDerivative(poly);

		for (int i = 0; i < iterations; i++) {
			Complex dx = Complex.div(poly.getValue(start), ableitung.getValue(start));
			start = Complex.subtr(start, dx);
			System.out.println(i + " : " + start);
			if (Complex.abs(dx) < precision) {
				return start;
			}
		}
		System.out.println("max itteration erreicht"); //error
		throw new InternalError();

	}
}
