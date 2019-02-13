import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int z = sc.nextInt();
		System.out.println(solve(n, m, z));

		sc.close();
	}

	static int solve(int n, int m, int z) {
		return z / lcm(n, m);
	}

	static int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}

	static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
