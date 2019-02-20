import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static long solve(int n) {
		long result = 0;
		long limit = 10;
		int digitNum = 1;
		while (n >= limit) {
			result += (limit / 10 * 9) * digitNum;

			limit *= 10;
			digitNum++;
		}
		result += (n - limit / 10 + 1) * digitNum;

		return result;
	}
}
