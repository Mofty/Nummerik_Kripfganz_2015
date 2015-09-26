import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFile {

	static public double[] readfile(String path) {

		double[] test1 = new double[8];
		int n = 0;
		Scanner in = null;
		try {
			in = new Scanner(new FileReader(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (in.hasNext()) {
			String input = (String) in.next();
			test1[n] = Double.parseDouble(input);
			n++;
		}
		in.close();
		return test1;
	}

}
