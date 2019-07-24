import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] r = new int[n];
		for (int i = 0; i < r.length; i++) {
			r[i] = sc.nextInt();
		}
		System.out.println(solve(r));

		sc.close();
	}

	static double solve(int[] r) {
		int[] sorted = Arrays.stream(r).boxed().sorted().mapToInt(x -> x).toArray();

		double result = 0;
		for (int i = sorted.length - 1; i >= 0; i -= 2) {
			result += Math.PI * (square(sorted[i]) - square((i == 0 ? 0 : sorted[i - 1])));
		}
		return result;
	}

	static int square(int x) {
		return x * x;
	}
}
