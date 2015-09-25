
public class ReelleNullstelle {
	public static double getRoot(double start, double precision, int iterations, Polynom poly) {
		double x1 = 1;
		double x2 = -1;
		Polynom ableitung = Ableitung.getDerivative(poly);


		for (int i = 0; i < iterations; i++) {
			double dx = poly.getValue(start) / ableitung.getValue(start);
			start -= dx;
			System.out.println(i + " : " + start);
			if ((x1 - start) * (start - x2) < 0.0) {
				System.out.println("kaputt lol");
				return 0;
			}
			if (Math.abs(dx) < precision) {
				return start;
			}
		}
		System.out.println("max itteration erreicht"); //error
		return 0;

	}
}
