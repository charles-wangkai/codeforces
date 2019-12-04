import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(k, a, b));

		sc.close();
	}

	static int solve(int k, int a, int b) {
		return ((a < k && b % k != 0) || (b < k && a % k != 0)) ? -1 : (a / k + b / k);
	}
}
