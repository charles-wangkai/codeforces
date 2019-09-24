import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		int[] g = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			g[i] = sc.nextInt();
		}
		System.out.println(solve(a, g));

		sc.close();
	}

	static String solve(int[] a, int[] g) {
		int n = a.length;

		int diff = Arrays.stream(a).sum();
		int countA = a.length;
		while (Math.abs(diff) > 500) {
			diff -= 1000;
			countA--;
		}

		return String.format("%s%s", repeat('A', countA), repeat('G', n - countA));
	}

	static String repeat(char ch, int count) {
		return IntStream.range(0, count).mapToObj(i -> ch)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
