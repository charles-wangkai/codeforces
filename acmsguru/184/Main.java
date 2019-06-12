import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int P = sc.nextInt();
		int M = sc.nextInt();
		int C = sc.nextInt();
		int K = sc.nextInt();
		int R = sc.nextInt();
		int V = sc.nextInt();
		System.out.println(solve(P, M, C, K, R, V));

		sc.close();
	}

	static int solve(int P, int M, int C, int K, int R, int V) {
		return Math.min(Math.min(P / K, M / R), C / V);
	}
}
