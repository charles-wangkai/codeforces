import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a));
		}

		sc.close();
	}

	static int solve(int[] a) {
		int[] counts = new int[3];
		for (int ai : a) {
			counts[ai % 3]++;
		}

		int min12 = Math.min(counts[1], counts[2]);

		return counts[0] + min12 + (counts[1] - min12) / 3 + (counts[2] - min12) / 3;
	}
}
