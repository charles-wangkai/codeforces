import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int m = sc.nextInt();
		int[] a = new int[m];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(s, a));

		sc.close();
	}

	static String solve(String s, int[] a) {
		int[] deltas = new int[s.length()];
		for (int ai : a) {
			deltas[ai - 1]++;

			if (ai != 1) {
				deltas[s.length() - ai + 1]--;
			}
		}

		StringBuilder result = new StringBuilder();
		int reverseCount = 0;
		for (int i = 0; i < s.length(); i++) {
			reverseCount += deltas[i];

			result.append(s.charAt((reverseCount % 2 == 0) ? i : (s.length() - 1 - i)));
		}

		return result.toString();
	}
}
