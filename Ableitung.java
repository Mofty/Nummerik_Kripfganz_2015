
public class Ableitung {
	
	public static Polynom getDerivative(Polynom poly) {

		Polynom ableitung = null;

		if (poly.getDegree() > 0) {
			double[] koeffizientenDerAbleitung = new double[poly.koeffizienten.length - 1];
			for (int i = 1; i < poly.koeffizienten.length; i++) {
				koeffizientenDerAbleitung[i - 1] = poly.koeffizienten[i] * i;
			}
			ableitung = new Polynom(koeffizientenDerAbleitung);
		} else {
			System.out.println("bitte geben sie ein polynom mit einen grad groesser 0 ein");
		}

		return ableitung;
	}

}
