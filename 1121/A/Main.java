import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		int[] s = new int[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}
		int[] c = new int[k];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(solve(p, s, m, c));

		sc.close();
	}

	static int solve(int[] p, int[] s, int m, int[] c) {
		int[] maxPowers = new int[m + 1];
		for (int i = 0; i < p.length; i++) {
			maxPowers[s[i]] = Math.max(maxPowers[s[i]], p[i]);
		}

		return (int) Arrays.stream(c).filter(ci -> p[ci - 1] != maxPowers[s[ci - 1]]).count();
	}
}
