import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.print(solve(n));

		sc.close();
	}

	static String solve(int n) {
		List<Integer> ys = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				for (int j = i; j <= n; j *= i) {
					ys.add(j);
				}
			}
		}

		return String.format("%d\n%s", ys.size(), ys.stream().map(String::valueOf).collect(Collectors.joining(" ")));
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
