import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		List<Integer> result = new ArrayList<>();
		for (int i = 2; i * i <= n; i++) {
			if (isPrime(i) && n % i == 0) {
				while (n % i == 0) {
					result.add(n);
					n /= i;
				}
			}
		}
		result.add(n);
		if (n != 1) {
			result.add(1);
		}

		return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
	}

	static boolean isPrime(int x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return false;
			}
		}

		return true;
	}
}
