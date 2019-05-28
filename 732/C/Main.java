import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long b = sc.nextLong();
		long d = sc.nextLong();
		long s = sc.nextLong();
		System.out.println(solve(b, d, s));

		sc.close();
	}

	static long solve(long b, long d, long s) {
		long[] meals = { b, d, s };
		long baseline = Arrays.stream(meals).max().getAsLong() - 1;

		return Arrays.stream(meals).map(meal -> Math.max(0, baseline - meal)).sum();
	}
}
