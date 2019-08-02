import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < q; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			System.out.println(solve(n, x, y));
		}
	}

	static long solve(int n, int x, int y) {
		if (isEven(n)) {
			if (isEven(x + y)) {
				return n / 2 * (x - 1L) + (y + 1) / 2;
			} else {
				return (long) n * n / 2 + n / 2 * (x - 1L) + (y + 1) / 2;
			}
		} else {
			if (isEven(x + y)) {
				return (x - 1L) / 2 * n + (isEven(x) ? ((n + 1) / 2) : 0) + (y + 1) / 2;
			} else {
				return ((long) n * n + 1) / 2 + (x - 1L) / 2 * n + (isEven(x) ? ((n - 1) / 2) : 0) + (y + 1) / 2;
			}
		}
	}

	static boolean isEven(int a) {
		return a % 2 == 0;
	}
}
