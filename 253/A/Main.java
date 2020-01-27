import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter("output.txt");

		int n = sc.nextInt();
		int m = sc.nextInt();
		out.println(solve(n, m));

		out.close();
		sc.close();
	}

	static String solve(int n, int m) {
		boolean boyOrGirl = n >= m;
		StringBuilder result = new StringBuilder();
		for (int i = n + m; i > 0; --i) {
			if (n != 0 && (boyOrGirl || m == 0)) {
				result.append('B');
				--n;
			} else {
				result.append('G');
				--m;
			}

			boyOrGirl = !boyOrGirl;
		}

		return result.toString();
	}
}
