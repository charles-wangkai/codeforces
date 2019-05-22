import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final String GENOME = "ACTG";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		return IntStream.rangeClosed(0, s.length() - GENOME.length())
				.map(i -> IntStream.range(0, GENOME.length()).map(j -> {
					int diff = Math.abs(s.charAt(i + j) - GENOME.charAt(j));
					return Math.min(diff, 26 - diff);
				}).sum()).min().getAsInt();
	}
}
