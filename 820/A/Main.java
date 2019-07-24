import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int c = sc.nextInt();
		int v0 = sc.nextInt();
		int v1 = sc.nextInt();
		int a = sc.nextInt();
		int l = sc.nextInt();
		System.out.println(solve(c, v0, v1, a, l));

		sc.close();
	}

	static int solve(int c, int v0, int v1, int a, int l) {
		int read = 0;
		int v = v0;
		for (int i = 1;; i++) {
			read += v - (i == 1 ? 0 : l);
			if (read >= c) {
				return i;
			}

			v = Math.min(v1, v + a);
		}
	}
}
