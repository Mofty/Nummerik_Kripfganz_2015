import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;



public class Polynom {

	private double koeffizienten[] = { 0.0 }; // Null-Polynom

	public Polynom(double[] koeffizienten) {
		this.koeffizienten = koeffizienten;
	}

	public Polynom getDerivative() {
		Polynom ableitung = null;

		if (getDegree() > 0) {
			double[] koeffizientenDerAbleitung = new double[koeffizienten.length - 1];
			for (int i = 1; i < koeffizienten.length; i++) {
				koeffizientenDerAbleitung[i - 1] = koeffizienten[koeffizienten.length - i - 1] * i;
			}
			ableitung = new Polynom(koeffizientenDerAbleitung);
		} else {
			ableitung = new Polynom();
		}

		return ableitung;
	}

	public Polynom() {
	}

	public double getValue(double x) {
		double funktionsWert = 0.0;

		for (int i = getDegree(); i >= 0; i--) {
			funktionsWert *= x;
			System.out.println(i + " " + funktionsWert);
			funktionsWert += getKoeffizient(i);
			System.out.println(i + " " + getKoeffizient(i));
		}

		return funktionsWert;
	}

	public int getDegree() {
		return this.koeffizienten.length - 1;

	}

	public double getKoeffizient(int stelle) {
		return koeffizienten[stelle];
	}

	public double getRoot(double start, double precision, int iterations) {
		Polynom ableitung = getDerivative();

		int i = 1;
		do {
			i++;
			start = start - (getValue(start) / ableitung.getValue(start));
			System.out.println(i - 1 + ": " + start);
		} while ((Math.abs(getValue(start)) > precision) && i <= iterations);
		return start;

	}

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

	public static void main(String[] args) {
		double x = 2;
		double[] test1 = new double[8];
		int n = 0;
		Scanner in = null;
		try {
			in = new Scanner(new FileReader("Daten8B.txt"));
		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  }
	
		  while (in.hasNext()) {
		   String input = (String) in.next();
		   test1[n] = Double.parseDouble(input);
		   n++;
		  }
		Polynom poly1 = new Polynom(test1);

		System.out.println("Polynom " + poly1.getDegree() + ". Grades");
		System.out.println(poly1);

		System.out.println("_____________________");
		System.out.println("1. Ableitung:");
		System.out.println(poly1.getDerivative());
		System.out.println("_____________________");
		System.out.println("Funktionswert an der Stelle: " + x + " beträgt: \n"
				+ "f(" + x + ")=" + poly1.getValue(x));
		System.out.println("_____________________");
		System.out.println("Newton-Verfahren x - f(x)/ f '(x)");
		System.out.println(poly1.getRoot(0.1, 0.000001, 100));

		System.out.println();

	}
}
