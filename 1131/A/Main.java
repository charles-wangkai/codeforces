import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long w1 = sc.nextLong();
		long h1 = sc.nextLong();
		long w2 = sc.nextLong();
		long h2 = sc.nextLong();
		System.out.println(solve(w1, h1, w2, h2));

		sc.close();
	}

	static long solve(long w1, long h1, long w2, long h2) {
		return (w1 + h1) * 2 + 4 + h2 * 2;
	}
}
