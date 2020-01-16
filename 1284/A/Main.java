import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] s = readArray(sc, n);
		String[] t = readArray(sc, m);
		int q = sc.nextInt();
		for (int tc = 0; tc < q; ++tc) {
			int y = sc.nextInt();

			System.out.println(solve(s, t, y));
		}

		sc.close();
	}

	static String[] readArray(Scanner sc, int size) {
		String[] result = new String[size];
		for (int i = 0; i < result.length; ++i) {
			result[i] = sc.next();
		}

		return result;
	}

	static String solve(String[] s, String[] t, int y) {
		return String.format("%s%s", s[(y - 1) % s.length], t[(y - 1) % t.length]);
	}
}
