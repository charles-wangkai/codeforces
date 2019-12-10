import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static String solve(int n, int k) {
		List<Integer> result = new ArrayList<>();
		int divisor = 2;
		for (int i = 0; i < k - 1; i++) {
			while (divisor * divisor <= n && n % divisor != 0) {
				divisor++;
			}

			if (divisor * divisor > n) {
				return "-1";
			}

			result.add(divisor);
			n /= divisor;
		}

		if (n == 1) {
			return "-1";
		}
		result.add(n);

		return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
	}
}
