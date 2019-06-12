import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		System.out.println(solve(N));

		sc.close();
	}

	static int solve(int N) {
		return (int) IntStream.rangeClosed(1, N).filter(x -> gcd(x, N) == 1).count();
	}

	static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
