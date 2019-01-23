import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		if (n == 0) {
			return 1;
		}

		int remainder = n % 4;
		if (remainder == 0) {
			return 6;
		} else if (remainder == 1) {
			return 8;
		} else if (remainder == 2) {
			return 4;
		} else {
			return 2;
		}
	}
}
