import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		System.out.println(solve(k));

		sc.close();
	}

	static int solve(int k) {
		int sequence = 0;
		for (int n = 1;; n++) {
			if (isPerfect(n)) {
				sequence++;

				if (sequence == k) {
					return n;
				}
			}
		}
	}

	static boolean isPerfect(int n) {
		int digitSum = 0;
		while (n != 0) {
			digitSum += n % 10;

			n /= 10;
		}
		return digitSum == 10;
	}
}
