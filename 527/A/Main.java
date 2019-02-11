import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		System.out.println(solve(a, b));

		sc.close();
	}

	static long solve(long a, long b) {
		return (b == 0) ? 0 : (a / b + solve(b, a % b));
	}
}
