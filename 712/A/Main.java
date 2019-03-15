import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(String.join(" ", Arrays.stream(solve(a)).mapToObj(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static int[] solve(int[] a) {
		return IntStream.range(0, a.length).map(i -> a[i] + ((i == a.length - 1) ? 0 : a[i + 1])).toArray();
	}
}
