import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int a3 = sc.nextInt();
		int a4 = sc.nextInt();
		System.out.println(solve(a1, a2, a3, a4) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int a1, int a2, int a3, int a4) {
		for (int code = 0; code < 8; code++) {
			int sum = a1;
			if ((code & 1) != 0) {
				sum += a2;
			}
			if ((code & 2) != 0) {
				sum += a3;
			}
			if ((code & 4) != 0) {
				sum += a4;
			}

			if (sum * 2 == a1 + a2 + a3 + a4) {
				return true;
			}
		}

		return false;
	}
}
