import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		System.out.print(solve(N));

		sc.close();
	}

	static String solve(int N) {
		int[] colors = new int[N + 1];
		Arrays.fill(colors, 1);

		boolean[] primes = new boolean[N + 1];
		Arrays.fill(primes, true);
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				for (int j = i * i; j < primes.length; j += i) {
					primes[j] = false;
				}

				for (long j = i; j < primes.length; j *= i) {
					for (int k = (int) j; k < primes.length; k += j) {
						colors[k]++;
					}
				}
			}
		}

		return String.format("%d\n%s", Arrays.stream(colors).max().getAsInt(), IntStream.range(1, colors.length)
				.mapToObj(i -> String.valueOf(colors[i])).collect(Collectors.joining(" ")));
	}
}
