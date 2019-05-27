import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		if (n == 0) {
			return "0 0 0";
		}

		int prevPrev = 0;
		int prev = 1;
		while (prevPrev + prev != n) {
			int curr = prevPrev + prev;

			prevPrev = prev;
			prev = curr;
		}
		return String.format("0 %d %d", prevPrev, prev);
	}
}
