import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] d = new int[n];
		for (int i = 0; i < d.length; i++) {
			d[i] = sc.nextInt();
		}
		int s = sc.nextInt();
		int t = sc.nextInt();
		System.out.println(solve(d, s, t));

		sc.close();
	}

	static int solve(int[] d, int s, int t) {
		int total = Arrays.stream(d).sum();
		int distance = IntStream.range(Math.min(s, t), Math.max(s, t)).map(i -> d[i - 1]).sum();

		return Math.min(distance, total - distance);
	}
}
