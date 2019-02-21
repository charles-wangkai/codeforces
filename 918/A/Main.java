import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		char[] chs = new char[n];
		Arrays.fill(chs, 'o');

		StringBuilder result = new StringBuilder(new String(chs));

		result.setCharAt(0, 'O');

		int prev = 1;
		int curr = 1;
		while (curr <= n) {
			result.setCharAt(curr - 1, 'O');

			int next = prev + curr;
			prev = curr;
			curr = next;
		}

		return result.toString();
	}
}
