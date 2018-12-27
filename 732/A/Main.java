import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(solve(k, r));

		sc.close();
	}

	static int solve(int k, int r) {
		for (int i = 1;; i++) {
			int remainder = k * i % 10;
			if (remainder == 0 || remainder == r) {
				return i;
			}
		}
	}
}
