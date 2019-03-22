import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] l = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		System.out.println(solve(l, r, x));

		sc.close();
	}

	static int solve(int[] l, int[] r, int x) {
		int result = 0;
		int current = 1;
		for (int i = 0; i < l.length; i++) {
			current += (l[i] - current) / x * x;
			result += r[i] - current + 1;

			current = r[i] + 1;
		}
		return result;
	}
}
