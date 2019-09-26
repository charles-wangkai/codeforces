import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		String str = String.valueOf(n);

		int next = str.charAt(0) - '0' + 1;
		for (int i = 0; i < str.length() - 1; i++) {
			next *= 10;
		}

		return next - n;
	}
}
