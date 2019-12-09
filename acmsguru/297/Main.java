import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] S = new int[M];
		for (int i = 0; i < S.length; i++) {
			S[i] = sc.nextInt();
		}
		System.out.println(solve(N, S));

		sc.close();
	}

	static int solve(int N, int[] S) {
		return Arrays.stream(S).sum() % N;
	}
}
