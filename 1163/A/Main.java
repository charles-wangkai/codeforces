import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(n, m));

		sc.close();
	}

	static int solve(int n, int m) {
		int remain = n - m;
		int maxGroup = n / 2;

		if (remain <= maxGroup) {
			return remain;
		} else {
			return Math.max(1, maxGroup - (remain - maxGroup - n % 2));
		}
	}
}
