import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static char[] POSITIONS = { 'v', '<', '^', '>' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char start = sc.next().charAt(0);
		char end = sc.next().charAt(0);
		int n = sc.nextInt();
		System.out.println(solve(start, end, n));

		sc.close();
	}

	static String solve(char start, char end, int n) {
		int startIndex = IntStream.range(0, POSITIONS.length).filter(i -> POSITIONS[i] == start).findAny().getAsInt();

		boolean isClockwise = POSITIONS[(startIndex + n) % POSITIONS.length] == end;
		boolean isCounterClockwise = POSITIONS[((startIndex - n) % POSITIONS.length + POSITIONS.length)
				% POSITIONS.length] == end;

		if (isClockwise && isCounterClockwise) {
			return "undefined";
		} else if (isClockwise) {
			return "cw";
		} else {
			return "ccw";
		}
	}
}
