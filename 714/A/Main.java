import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long l1 = sc.nextLong();
		long r1 = sc.nextLong();
		long l2 = sc.nextLong();
		long r2 = sc.nextLong();
		long k = sc.nextLong();
		System.out.println(solve(l1, r1, l2, r2, k));

		sc.close();
	}

	static long solve(long l1, long r1, long l2, long r2, long k) {
		long left = Math.max(l1, l2);
		long right = Math.min(r1, r2);

		return Math.max(0, right - left + 1 - ((k >= left && k <= right) ? 1 : 0));
	}
}
