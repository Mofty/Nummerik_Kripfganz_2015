
public class Main {

	public static void main(String[] args) {
		Complex x = new Complex(1, 0);

		double[] test1 = ReadFile.readfile(args[0]);

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
		System.out.println("Real");
		System.out.println(ReelleNullstelle.getRoot(new Complex(0, 0), 0.000001, 100000, poly));
		System.out.println("Imaginär 1");
		System.out.println(ReelleNullstelle.getRoot(new Complex(0, 1), 0.000001, 100000, poly));
		System.out.println("Imaginär 2");
		System.out.println(ReelleNullstelle.getRoot(new Complex(0, -1), 0.000001, 100000, poly));
		System.out.println("Imaginär 3");
		System.out.println(ReelleNullstelle.getRoot(new Complex(1, 1), 0.000001, 100000, poly));
		System.out.println("Imaginär 4");
		System.out.println(ReelleNullstelle.getRoot(new Complex(-1, 1), 0.000001, 100000, poly));
		System.out.println("Imaginär 5");
		System.out.println(ReelleNullstelle.getRoot(new Complex(-1, -1), 0.000001, 100000, poly));

		System.out.println();

	}
}
