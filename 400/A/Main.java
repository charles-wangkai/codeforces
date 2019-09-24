import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			String cards = sc.next();

			System.out.println(solve(cards));
		}

		sc.close();
	}

	static String solve(String cards) {
		int[] rows = IntStream.rangeClosed(1, 12).filter(a -> {
			if (12 % a != 0) {
				return false;
			}

			int b = 12 / a;

			return IntStream.range(0, b)
					.anyMatch(c -> IntStream.range(0, a).allMatch(r -> cards.charAt(r * b + c) == 'X'));
		}).toArray();

		return String.format("%d %s", rows.length, Arrays.stream(rows)
				.mapToObj(row -> String.format("%dx%d", row, 12 / row)).collect(Collectors.joining(" ")));
	}
}
