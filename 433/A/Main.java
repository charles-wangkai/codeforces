import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < w.length; i++) {
			w[i] = sc.nextInt();
		}
		System.out.println(solve(w) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] w) {
		int count100 = (int) Arrays.stream(w).filter(x -> x == 100).count();
		int count200 = w.length - count100;

		return count100 % 2 == 0 && (count200 % 2 == 0 || count100 != 0);
	}
}
