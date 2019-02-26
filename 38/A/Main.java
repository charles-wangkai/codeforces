import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] d = new int[n - 1];
		for (int i = 0; i < d.length; i++) {
			d[i] = sc.nextInt();
		}
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(d, a, b));

		sc.close();
	}

	static int solve(int[] d, int a, int b) {
		return IntStream.range(a - 1, b - 1).map(i -> d[i]).sum();
	}
}
