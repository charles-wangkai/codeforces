import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		int minOff = n / 7 * 2 + Math.max(0, n % 7 - 5);
		int maxOff = n / 7 * 2 + Math.min(2, n % 7);

		return String.format("%d %d", minOff, maxOff);
	}
}
