import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		return (int) IntStream.range(0, s.length()).mapToObj(i -> s.substring(i) + s.substring(0, i)).distinct()
				.count();
	}
}
