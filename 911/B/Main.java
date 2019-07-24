import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(n, a, b));

		sc.close();
	}

	static int solve(int n, int a, int b) {
		return IntStream.range(1, n).map(i -> Math.min(a / i, b / (n - i))).max().getAsInt();
	}
}
