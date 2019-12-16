import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		System.out.println(solve(a, b, c, d, e, f));

		sc.close();
	}

	static int solve(int a, int b, int c, int d, int e, int f) {
		int result = 0;
		for (int suitOne = 0; suitOne <= Math.min(a, d); suitOne++) {
			result = Math.max(result, suitOne * e + Math.min(Math.min(b, c), d - suitOne) * f);
		}

		return result;
	}
}
