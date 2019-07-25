import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] d = new int[n];
		for (int i = 0; i < d.length; i++) {
			d[i] = sc.nextInt();
		}
		System.out.println(solve(d, k));

		sc.close();
	}

	static int solve(int[] d, int k) {
		int[] counts = new int[k];
		for (int di : d) {
			counts[di % k]++;
		}

		int result = 0;
		for (int i = 0; i * 2 <= k; i++) {
			int other = (k - i) % k;
			if (other == i) {
				result += counts[i] / 2 * 2;
			} else {
				result += Math.min(counts[i], counts[other]) * 2;
			}
		}
		return result;
	}
}
