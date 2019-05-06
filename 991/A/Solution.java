import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt();
		System.out.println(solve(A, B, C, N));

		sc.close();
	}

	static int solve(int A, int B, int C, int N) {
		int notPassNum = N - (A + B - C);

		return (C > A || C > B || notPassNum < 1) ? -1 : notPassNum;
	}
}
