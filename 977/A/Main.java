import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static int solve(int n, int k) {
		for (int i = 0; i < k; i++) {
			if (n % 10 == 0) {
				n /= 10;
			} else {
				n--;
			}
		}
		return n;
	}
}
