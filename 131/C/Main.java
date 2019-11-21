import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		System.out.println(solve(n, m, t));

		sc.close();
	}

	static long solve(int n, int m, int t) {
		long result = 0;
		for (int boyNum = 4; t - boyNum >= 1; boyNum++) {
			result += C(n, boyNum) * C(m, t - boyNum);
		}

		return result;
	}

	static long C(int n, int r) {
		long result = 1;
		for (int i = 0; i < r; i++) {
			result = result * (n - i) / (i + 1);
		}

		return result;
	}
}
