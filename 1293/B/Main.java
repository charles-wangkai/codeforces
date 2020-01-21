import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static double solve(int n) {
		return IntStream.rangeClosed(1, n).mapToDouble(i -> 1.0 / i).sum();
	}
}
