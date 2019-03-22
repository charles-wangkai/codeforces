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
		if (m % n != 0) {
			return -1;
		}

		int remain = m / n;
		int result = 0;
		for (int divisor : new int[] { 2, 3 }) {
			while (remain % divisor == 0) {
				remain /= divisor;
				result++;
			}
		}

		return (remain == 1) ? result : -1;
	}
}
