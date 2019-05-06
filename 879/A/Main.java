import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] s = new int[n];
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		System.out.println(solve(s, d));

		sc.close();
	}

	static int solve(int[] s, int[] d) {
		return IntStream.range(0, s.length).reduce(-1,
				(result, i) -> Math.max(0, divideToCeil(result + 1 - s[i], d[i])) * d[i] + s[i]);
	}

	static int divideToCeil(int x, int y) {
		if (x < 0) {
			return 0;
		}

		return x / y + (x % y == 0 ? 0 : 1);
	}
}
