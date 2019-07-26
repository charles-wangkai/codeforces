import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int m = sc.nextInt();
		String s = sc.next();
		int[] x = new int[m];
		char[] c = new char[m];
		for (int i = 0; i < m; i++) {
			x[i] = sc.nextInt();
			c[i] = sc.next().charAt(0);
		}
		System.out.print(solve(s, x, c));

		sc.close();
	}

	static String solve(String s, int[] x, char[] c) {
		int f = 0;
		int periodCount = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '.') {
				periodCount++;

				if (periodCount >= 2) {
					f++;
				}
			} else {
				periodCount = 0;
			}
		}

		StringBuilder str = new StringBuilder(s);
		int[] result = new int[x.length];
		for (int i = 0; i < result.length; i++) {
			int index = x[i] - 1;

			boolean leftPeriod = index >= 1 && str.charAt(index - 1) == '.';
			boolean rightPeriod = index <= str.length() - 2 && str.charAt(index + 1) == '.';

			if (c[i] == '.') {
				if (str.charAt(index) != '.') {
					if (leftPeriod && rightPeriod) {
						f += 2;
					} else if (leftPeriod || rightPeriod) {
						f++;
					}
				}
			} else {
				if (str.charAt(index) == '.') {
					if (leftPeriod && rightPeriod) {
						f -= 2;
					} else if (leftPeriod || rightPeriod) {
						f--;
					}
				}
			}

			str.setCharAt(index, c[i]);
			result[i] = f;
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
	}
}
