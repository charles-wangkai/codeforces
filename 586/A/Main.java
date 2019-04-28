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
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		return (int) IntStream.range(0, a.length)
				.filter(i -> a[i] == 1 || (i >= 1 && a[i - 1] == 1 && i + 1 < a.length && a[i + 1] == 1)).count();
	}
}
