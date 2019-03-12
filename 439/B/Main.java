import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(solve(c, x));

		sc.close();
	}

	static long solve(int[] c, int x) {
		int[] sorted = Arrays.stream(c).boxed().sorted().mapToInt(a -> a).toArray();

		return IntStream.range(0, c.length).mapToLong(i -> sorted[i] * Math.max(1L, x - i)).sum();
	}
}
