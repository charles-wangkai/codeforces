import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(solve(l, r));

		sc.close();
	}

	static int solve(int l, int r) {
		return IntStream.rangeClosed(l, r).filter(x -> {
			String str = String.valueOf(x);

			return str.chars().distinct().count() == str.length();
		}).findAny().orElse(-1);
	}
}
