import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static int solve(int n, int k) {
		int lower = 0;
		int upper = n;
		while (true) {
			int middle = (lower + upper) / 2;
			long delta = (n - middle) * (n - middle + 1L) / 2 - (k + middle);
			if (delta == 0) {
				return middle;
			} else if (delta < 0) {
				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}
	}
}
