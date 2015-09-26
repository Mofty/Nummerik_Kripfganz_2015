
public class Main {

	public static void main(String[] args) {
		Complex x = new Complex(1, 0);
		
		double[] test1 = ReadFile.readfile("/Daten8B.txt");
		
		Polynom poly = new Polynom(test1);

		System.out.println("Polynom " + poly.getDegree() + ". Grades");
		System.out.println(poly);

		System.out.println("_____________________");
		System.out.println("1. Ableitung:");
		System.out.println(Ableitung.getDerivative(poly));
		System.out.println("_____________________");
		System.out.println("Funktionswert an der Stelle: " + x + " beträgt: \n"	+ "f(" + x + ")=" + poly.getValue(x));
		System.out.println("_____________________");
		System.out.println("Newton-Verfahren x - f(x)/ f '(x)");
		System.out.println("reale Nullstelle");
		System.out.println("mit den Startwerten 0 für den Realteil und 0 mal den Imaginärteil");
		System.out.println("Nullstelle bei: " + Nullstelle.getRoot(new Complex(0, 0), 0.000001, 100000, poly));
		System.out.println("imaginäre Nullstelle 1: ");
		System.out.println("mit den Startwerten 0 für den Realteil und 1 für den Imaginärteil");
		System.out.println("Nullstelle bei: " + Nullstelle.getRoot(new Complex(0, 1), 0.000001, 100000, poly));
		System.out.println("imaginäre Nullstelle 2: ");
		System.out.println("mit den Startwerten 0 für den Realteil und -1 für den Imaginärteil");
		System.out.println("Nullstelle bei: " + Nullstelle.getRoot(new Complex(0, -1), 0.000001, 100000, poly));
		System.out.println("imaginäre Nullstelle 3: ");
		System.out.println("mit den Startwerten 1 für den Realteil und 1 für den Imaginärteil");
		System.out.println("Nullstelle bei: " + Nullstelle.getRoot(new Complex(1, 1), 0.000001, 100000, poly));
		System.out.println("imaginäre Nullstelle 4: ");
		System.out.println("mit den Startwerten 1 für den Realteil und -1 für den Imaginärteil");
		System.out.println("Nullstelle bei: " + Nullstelle.getRoot(new Complex(1, -1), 0.000001, 100000, poly));
		System.out.println("imaginäre Nullstelle 5: ");
		System.out.println("mit den Startwerten -1 für den Realteil und 1 für den Imaginärteil");
		System.out.println("Nullstelle bei: " + Nullstelle.getRoot(new Complex(-1, 1), 0.000001, 100000, poly));
		System.out.println("imaginäre Nullstelle 6: ");
		System.out.println("mit den Startwerten -1 für den Realteil und -1 für den Imaginärteil");
		System.out.println("Nullstelle bei: " + Nullstelle.getRoot(new Complex(-1, -1), 0.000001, 100000, poly));

		System.out.println();

	}
}
