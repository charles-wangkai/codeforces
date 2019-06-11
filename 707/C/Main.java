import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		if (n <= 2) {
			return "-1";
		}

		long a;
		long b;
		if (n % 2 == 0) {
			a = (long) n * n / 4 - 1;
			b = a + 2;
		} else {
			a = (long) n * n / 2;
			b = a + 1;
		}

		return String.format("%d %d", a, b);
	}
}
