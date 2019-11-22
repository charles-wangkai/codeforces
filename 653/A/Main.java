import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = sc.nextInt();
		}
		System.out.println(solve(t) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] t) {
		int[] sorted = Arrays.stream(t).distinct().sorted().toArray();

		return IntStream.range(0, sorted.length - 2)
				.anyMatch(i -> sorted[i] + 1 == sorted[i + 1] && sorted[i] + 2 == sorted[i + 2]);
	}
}
