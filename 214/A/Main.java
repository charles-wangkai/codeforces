import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(n, m));

		sc.close();
	}

	static int solve(int n, int m) {
		int pairNum = 0;
		for (int a = 0; a * a <= n; a++) {
			int b = n - a * a;
			if (a + b * b == m) {
				pairNum++;
			}
		}
		return pairNum;
	}
}
