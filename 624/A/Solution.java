import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int d = sc.nextInt();
		int L = sc.nextInt();
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		System.out.println(solve(d, L, v1, v2));

		sc.close();
	}

	static double solve(int d, int L, int v1, int v2) {
		return (double) (L - d) / (v1 + v2);
	}
}
