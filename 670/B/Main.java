import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] id = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = sc.nextInt();
		}
		System.out.println(solve(id, k));

		sc.close();
	}

	static int solve(int[] id, int k) {
		for (int i = 1;; i++) {
			if (k <= i) {
				return id[k - 1];
			}

			k -= i;
		}
	}
}
