import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int ta = sc.nextInt();
			int fa = sc.nextInt();
			int tb = sc.nextInt();
			int fb = sc.nextInt();

			System.out.println(solve(a, b, ta, fa, tb, fb));
		}

		sc.close();
	}

	static int solve(int a, int b, int ta, int fa, int tb, int fb) {
		if (ta == tb) {
			return Math.abs(fa - fb);
		} else {
			int transfer;
			if (fa < a) {
				transfer = a;
			} else if (fa > b) {
				transfer = b;
			} else {
				transfer = fa;
			}

			return Math.abs(ta - tb) + Math.abs(fa - transfer) + Math.abs(fb - transfer);
		}
	}
}
