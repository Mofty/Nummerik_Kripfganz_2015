
public class Main {

	public static void main(String[] args) {
		double x = 1;

		double[] test1 = ReadFile.readfile();

		Polynom poly = new Polynom(test1);

		System.out.println("Polynom " + poly.getDegree() + ". Grades");
		System.out.println(poly);

		System.out.println("_____________________");
		System.out.println("1. Ableitung:");
		System.out.println(Ableitung.getDerivative(poly));
		System.out.println("_____________________");
		System.out.println("Funktionswert an der Stelle: " + x + " beträgt: \n"
				+ "f(" + x + ")=" + poly.getValue(x));
		System.out.println("_____________________");
		System.out.println("Newton-Verfahren x - f(x)/ f '(x)");
		System.out.println(ReelleNullstelle.getRoot(0.0, 0.000001, 100000, poly));

		System.out.println();

	}
}
