import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();
		int K = sc.nextInt();
		long[] a = new long[K];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextLong();
		}
		System.out.println(solve(N, a));

		sc.close();
	}

	static String solve(long N, long[] a) {
		return IntStream.range(0, a.length).boxed().min((index1, index2) -> Long.compare(N % a[index1], N % a[index2]))
				.map(i -> String.format("%d %d", i + 1, N / a[i])).get();
	}
}
