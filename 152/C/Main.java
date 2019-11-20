import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int MODULUS = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] names = new String[n];
		for (int i = 0; i < names.length; i++) {
			names[i] = sc.next();
		}
		System.out.println(solve(names, m));

		sc.close();
	}

	static int solve(String[] names, int m) {
		return IntStream.range(0, m).reduce(1, (result, i) -> multiplyMod(result,
				(int) Arrays.stream(names).map(name -> name.charAt(i)).distinct().count()));
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}
}
