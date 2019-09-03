import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int MODULUS = 998_244_353;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		int h = sc.nextInt();
		System.out.println(solve(w, h));

		sc.close();
	}

	static int solve(int w, int h) {
		return IntStream.range(0, w + h).reduce(1, (result, element) -> multiplyMod(result, 2));
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}
}
