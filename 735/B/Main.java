import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, n1, n2));

		sc.close();
	}

	static double solve(int[] a, int n1, int n2) {
		int[] sorted = Arrays.stream(a).boxed().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();

		int minSize = Math.min(n1, n2);
		return IntStream.range(0, minSize).mapToDouble(i -> sorted[i]).sum() / minSize
				+ IntStream.range(minSize, n1 + n2).mapToDouble(i -> sorted[i]).sum() / (n1 + n2 - minSize);
	}
}
