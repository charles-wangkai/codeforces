import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static long solve(int n) {
		return square(n - 2);
	}

	static long square(int x) {
		return (long) x * x;
	}
}
