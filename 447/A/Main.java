import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int p = sc.nextInt();
		int n = sc.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(p, x));

		sc.close();
	}

	static int solve(int p, int[] x) {
		boolean[] filled = new boolean[p];
		for (int i = 0; i < x.length; i++) {
			int bucketId = x[i] % p;

			if (filled[bucketId]) {
				return i + 1;
			}

			filled[bucketId] = true;
		}

		return -1;
	}
}
