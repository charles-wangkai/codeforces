import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		int h = sc.nextInt();
		int u1 = sc.nextInt();
		int d1 = sc.nextInt();
		int u2 = sc.nextInt();
		int d2 = sc.nextInt();
		System.out.println(solve(w, h, u1, d1, u2, d2));

		sc.close();
	}

	static int solve(int w, int h, int u1, int d1, int u2, int d2) {
		for (int i = h; i >= 0; i--) {
			w += i;

			if (i == d1) {
				w = Math.max(0, w - u1);
			} else if (i == d2) {
				w = Math.max(0, w - u2);
			}
		}
		return w;
	}
}
