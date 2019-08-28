
// https://blog.csdn.net/ahfywff/article/details/7432524

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(solve(A, B));

		sc.close();
	}

	static int solve(int A, int B) {
		if (A == 0 || B == 0) {
			return 0;
		}

		int n = (A + B) / gcd(A, B);
		int result = 0;
		while (n % 2 == 0) {
			n /= 2;
			result++;
		}

		return (n == 1) ? result : -1;
	}

	static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
