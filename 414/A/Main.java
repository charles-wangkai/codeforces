import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.print(solve(n, k));

		sc.close();
	}

	static String solve(int n, int k) {
		if (n / 2 > k || (n == 1 && k != 0)) {
			return "-1";
		}

		if (n == 1) {
			return "1";
		}

		int[] result = new int[n];
		result[0] = k - (n / 2 - 1);
		result[1] = result[0] * 2;
		for (int i = 2; i < result.length; i++) {
			result[i] = result[i - 1] + 1;
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
