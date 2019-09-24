import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int p = sc.nextInt();
		System.out.println(solve(k, p));

		sc.close();
	}

	static int solve(int k, int p) {
		int half = 1;
		int result = 0;
		for (int i = 0; i < k; i++) {
			long number = Long.parseLong(String.format("%s%s", String.valueOf(half),
					new StringBuilder(String.valueOf(half)).reverse().toString()));

			result = addMod(result, number, p);

			half++;
		}

		return result;
	}

	static int addMod(int x, long y, int p) {
		return (int) ((x + y) % p);
	}
}
