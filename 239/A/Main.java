import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int y = sc.nextInt();
		int k = sc.nextInt();
		int n = sc.nextInt();
		System.out.print(solve(y, k, n));

		sc.close();
	}

	static String solve(int y, int k, int n) {
		List<Integer> xs = new ArrayList<>();
		for (int x = k - y % k; x + y <= n; x += k) {
			xs.add(x);
		}

		return xs.isEmpty() ? "-1" : xs.stream().map(String::valueOf).collect(Collectors.joining(" "));
	}
}
