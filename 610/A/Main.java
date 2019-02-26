import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		if (n % 2 != 0) {
			return 0;
		}

		int half = n / 2;

		return half / 2 - (half % 2 == 0 ? 1 : 0);
	}
}
