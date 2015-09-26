import java.io.InputStream;
import java.util.Scanner;

public class ReadFile {

	static public double[] readfile(String path) {
		
		InputStream input = Main.class.getResourceAsStream(path);

		double[] test1 = new double[8];
		int n = 0;
		Scanner in = null;
		in = new Scanner(input);

		while (in.hasNext()) {
			String inp = (String) in.next();
			test1[n] = Double.parseDouble(inp);
			n++;
		}
		in.close();
		return test1;
	}

}
