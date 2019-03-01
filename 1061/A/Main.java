import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int S = sc.nextInt();
		System.out.println(solve(n, S));

		sc.close();
	}

	static int solve(int n, int S) {
		return S / n + (S % n == 0 ? 0 : 1);
	}
}
