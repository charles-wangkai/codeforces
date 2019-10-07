import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int PART = 4;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] l = new int[PART];
		int[] s = new int[PART];
		int[] r = new int[PART];
		int[] p = new int[PART];
		for (int i = 0; i < PART; i++) {
			l[i] = sc.nextInt();
			s[i] = sc.nextInt();
			r[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		System.out.println(solve(l, s, r, p) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] l, int[] s, int[] r, int[] p) {
		return IntStream.range(0, PART).anyMatch(i -> p[i] == 1 && (l[i] == 1 || s[i] == 1 || r[i] == 1
				|| l[(i + 1) % PART] == 1 || s[(i + 2) % PART] == 1 || r[(i + 3) % PART] == 1));
	}
}
