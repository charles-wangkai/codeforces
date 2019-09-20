import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int[] s = new int[n];
			for (int i = 0; i < s.length; i++) {
				s[i] = sc.nextInt();
			}

			System.out.println(solve(s) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int[] s) {
		return Arrays.stream(s).filter(x -> x <= 2048).sum() >= 2048;
	}
}
