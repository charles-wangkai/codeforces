import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(solve(a, b, c));

		sc.close();
	}

	static String solve(int a, int b, int c) {
		if ((a + b + c) % 2 != 0) {
			return "Impossible";
		}

		int[] result = IntStream.of(c, a, b).map(x -> (a + b + c) / 2 - x).toArray();
		if (Arrays.stream(result).min().getAsInt() < 0 || Arrays.stream(result).filter(x -> x == 0).count() >= 2) {
			return "Impossible";
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
