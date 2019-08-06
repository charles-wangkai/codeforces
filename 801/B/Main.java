import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String x = sc.next();
		String y = sc.next();
		System.out.println(solve(x, y));

		sc.close();
	}

	static String solve(String x, String y) {
		return IntStream.range(0, x.length()).anyMatch(i -> x.charAt(i) < y.charAt(i)) ? "-1" : y;
	}
}
