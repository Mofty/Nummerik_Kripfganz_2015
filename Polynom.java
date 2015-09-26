
public class Polynom{
	
	public double[] koeffizienten;

	public Polynom(double[] koeffizienten) {
		this.koeffizienten = koeffizienten;
	}
	
	public double getKoeffizient(int stelle) {
		return koeffizienten[stelle];
	}
	
	public int getDegree() {
		return koeffizienten.length - 1;

	}

	public Complex getValue(Complex x){
		Complex funktionsWert = Complex.zero();

		for (int i = getDegree(); i >= 0; i--) {
			funktionsWert = Complex.mult(funktionsWert, x);
			funktionsWert = Complex.sum(funktionsWert, Complex.fromReal(getKoeffizient(i)));
		}

		return funktionsWert;
	}

//	@Override
//	public String toString() {
//		String result = "0";
//		for (int i = 0; i < getDegree() + 1; i++) {
//			result += " + " + koeffizienten[i] + " * x ^ " + (getDegree() - i);
//		}
//		return result;
//	}

	@Override
	public String toString() {

		System.out.print("f(x)=");
		if (getDegree() < 0)
			System.out.println("ERROR: Grad negativ!");
		if (getDegree() == 0)
			System.out.println(koeffizienten[0]);
		if (getDegree() > 0) {
			System.out.print(koeffizienten[getDegree()]);
			if (getDegree() > 1) {
				System.out.print("*x^");
				System.out.print(getDegree());
			} else
				System.out.print("x");
			for (int i = getDegree() - 1; i >= 0; i--) {
				if (koeffizienten[i] > 0)
					System.out.print(" +");
				if (koeffizienten[i] < 0)
					System.out.print(" ");
				if (koeffizienten[i] != 0) {
					System.out.print(koeffizienten[i]);
					if (i > 1) {
						System.out.print("*x^");
						System.out.print(i);
					} else if (i == 1)
						System.out.print("x");
				}
			}

		}

		return "";
	}

}