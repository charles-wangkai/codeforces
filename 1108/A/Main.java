import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int l1 = sc.nextInt();
			int r1 = sc.nextInt();
			int l2 = sc.nextInt();
			int r2 = sc.nextInt();

			System.out.println(solve(l1, r1, l2, r2));
		}

		sc.close();
	}

	static String solve(int l1, int r1, int l2, int r2) {
		return String.format("%d %d", l1, (l2 == l1) ? r2 : l2);
	}
}
