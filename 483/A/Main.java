import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long l = sc.nextLong();
		long r = sc.nextLong();
		System.out.println(solve(l, r));

		sc.close();
	}

	static String solve(long l, long r) {
		long a = l + l % 2;
		long b = a + 1;
		long c = a + 2;

		return (c <= r) ? String.format("%d %d %d", a, b, c) : "-1";
	}
}
