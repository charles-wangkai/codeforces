import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int k = sc.nextInt();

			System.out.println(solve(a, b, k));
		}

		sc.close();
	}

	static long solve(int a, int b, int k) {
		return (long) (a - b) * (k / 2) + (k % 2 == 0 ? 0 : a);
	}
}
