import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.print(solve(n));

		sc.close();
	}

	static String solve(int n) {
		StringBuilder result = new StringBuilder();
		int leftNumber = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				if (j != 0) {
					result.append(' ');
				}

				result.append(leftNumber).append(' ').append(n * n + 1 - leftNumber);
				leftNumber++;
			}

			result.append('\n');
		}
		return result.toString();
	}
}
