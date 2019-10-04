import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int a = sc.nextInt();

			System.out.println(solve(a));
		}

		sc.close();
	}

	static int solve(int a) {
		String str = Integer.toBinaryString(a);

		if (str.indexOf('0') >= 0) {
			return (1 << str.length()) - 1;
		}

		for (int i = 2; i * i <= a; i++) {
			if (a % i == 0) {
				int lower = a / i;

				if ((lower ^ (a - lower)) == a) {
					return lower;
				}
			}
		}

		return 1;
	}
}
