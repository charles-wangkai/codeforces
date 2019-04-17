import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] x = new int[4];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(x));

		sc.close();
	}

	static String solve(int[] x) {
		Arrays.sort(x);

		return IntStream.range(0, x.length - 1).mapToObj(i -> String.valueOf(x[x.length - 1] - x[i]))
				.collect(Collectors.joining(" "));
	}
}
