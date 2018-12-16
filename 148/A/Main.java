import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int l = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int d = sc.nextInt();
		System.out.println(solve(k, l, m, n, d));

		sc.close();
	}

	static int solve(int k, int l, int m, int n, int d) {
		return (int) IntStream.rangeClosed(1, d).filter(x -> x % k == 0 || x % l == 0 || x % m == 0 || x % n == 0)
				.count();
	}
}
