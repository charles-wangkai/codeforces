import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		int r = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(l, r, x, y, k) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int l, int r, int x, int y, int k) {
		return IntStream.rangeClosed(x, y).anyMatch(b -> (long) k * b >= l && (long) k * b <= r);
	}
}
