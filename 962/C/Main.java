import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		String s = String.valueOf(n);

		int result = Integer.MAX_VALUE;
		for (int code = 1; code < 1 << s.length(); ++code) {
			String selected = decode(s, code);
			if (!selected.startsWith("0") && isSquare(Integer.parseInt(selected))) {
				result = Math.min(result, s.length() - selected.length());
			}
		}

		return (result == Integer.MAX_VALUE) ? -1 : result;
	}

	static String decode(String s, int code) {
		StringBuilder result = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if ((code & 1) != 0) {
				result.append(ch);
			}

			code >>= 1;
		}

		return result.toString();
	}

	static boolean isSquare(int x) {
		int root = (int) Math.round(Math.sqrt(x));

		return root * root == x;
	}
}
