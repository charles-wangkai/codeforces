import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] solution = solve(n);
		System.out.println(solution.length);
		System.out.println(String.join(" ", Arrays.stream(solution).mapToObj(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static int[] solve(int n) {
		if (n == 1 || n == 2) {
			return new int[] { 1 };
		} else if (n == 3) {
			return new int[] { 1, 3 };
		} else if (n == 4) {
			return new int[] { 3, 1, 4, 2 };
		} else {
			return IntStream.range(0, n).map(i -> (i % 2 == 0) ? (i / 2 + 1) : (i / 2 + (n + 1) / 2 + 1)).toArray();
		}
	}
}
