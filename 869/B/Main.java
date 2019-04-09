import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		System.out.println(solve(a, b));

		sc.close();
	}

	static int solve(long a, long b) {
		int result = 1;
		for (long i = a + 1; i <= b; i++) {
			result = (int) (result * i % 10);

			if (result == 0) {
				break;
			}
		}
		return result;
	}
}
