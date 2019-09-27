import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final char[] SEQUENCE = { 'R', 'G', 'B' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();

			System.out.println(solve(s, k));
		}

		sc.close();
	}

	static int solve(String s, int k) {
		return IntStream.rangeClosed(0, s.length() - k).map(beginIndex -> IntStream.range(0, SEQUENCE.length)
				.map(offset -> (int) IntStream.range(0, k)
						.filter(i -> s.charAt(beginIndex + i) != SEQUENCE[(offset + i) % SEQUENCE.length]).count())
				.min().getAsInt()).min().getAsInt();
	}
}
