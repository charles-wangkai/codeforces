import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		System.out.println(solve(p));

		sc.close();
	}

	static int solve(int[] p) {
		boolean[] used = new boolean[p.length];
		int remain = p.length;
		int group = 0;
		while (remain != 0) {
			boolean[] nextUsed = Arrays.copyOf(used, used.length);
			for (int i = 0; i < nextUsed.length; i++) {
				if (!used[i] && (p[i] == -1 || used[p[i] - 1])) {
					nextUsed[i] = true;
					remain--;
				}
			}
			used = nextUsed;

			group++;
		}
		return group;
	}
}
