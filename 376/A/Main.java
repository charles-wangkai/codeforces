import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		String[] parts = s.split("\\^");

		long leftMoment = computeMoment(new StringBuilder(parts[0]).reverse().toString());
		long rightMoment = computeMoment(parts[1]);

		if (leftMoment < rightMoment) {
			return "right";
		} else if (leftMoment > rightMoment) {
			return "left";
		} else {
			return "balance";
		}
	}

	static long computeMoment(String side) {
		return IntStream.range(0, side.length())
				.map(i -> ((side.charAt(i) == '=') ? 0 : (side.charAt(i) - '0')) * (i + 1)).asLongStream().sum();
	}
}
