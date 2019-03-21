import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] l = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(solve(l, r, k));

		sc.close();
	}

	static int solve(int[] l, int[] r, int k) {
		return l.length - (int) Arrays.stream(r).filter(x -> x < k).count();
	}
}
