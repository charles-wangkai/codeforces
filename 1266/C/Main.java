import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(solve(r, c));

		sc.close();
	}

	static String solve(int r, int c) {
		if (r == 1 && c == 1) {
			return "0";
		}

		int[] rowGcds;
		int[] colGcds;
		if (c == 1) {
			rowGcds = IntStream.rangeClosed(2, r + 1).toArray();
			colGcds = new int[] { 1 };
		} else {
			rowGcds = IntStream.rangeClosed(1, r).toArray();
			colGcds = IntStream.rangeClosed(r + 1, r + c).toArray();
		}

		return IntStream.range(0, r).mapToObj(i -> IntStream.range(0, c)
				.mapToObj(j -> String.valueOf(rowGcds[i] * colGcds[j])).collect(Collectors.joining(" ")))
				.collect(Collectors.joining("\n"));
	}
}
