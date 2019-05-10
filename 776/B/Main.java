import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.print(solve(n));

		sc.close();
	}

	static String solve(int n) {
		int[] colors = IntStream.range(2, 2 + n).map(x -> isPrime(x) ? 1 : 2).toArray();
		int k = (int) Arrays.stream(colors).distinct().count();

		return String.format("%d\n%s", k,
				Arrays.stream(colors).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}

	static boolean isPrime(int x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
}
