import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		for (int i = 1;; i++) {
			if (Long.parseLong(Integer.toBinaryString(i)) > n) {
				return i - 1;
			}
		}
	}
}
