import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		System.out.println(solve(k));

		sc.close();
	}

	static long solve(int k) {
		if (k > 36) {
			return -1;
		}

		return Long.parseLong(String.format("%s%s", repeat('8', k / 2), repeat('4', k % 2)));
	}

	static String repeat(char ch, int count) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < count; i++) {
			result.append(ch);
		}
		return result.toString();
	}
}
