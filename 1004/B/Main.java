import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] l = new int[m];
		int[] r = new int[m];
		for (int i = 0; i < m; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		System.out.println(solve(n, l, r));

		sc.close();
	}

	static String solve(int n, int[] l, int[] r) {
		return IntStream.range(0, n).mapToObj(i -> String.valueOf(i % 2)).collect(Collectors.joining());
	}
}
