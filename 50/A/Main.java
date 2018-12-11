import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();
		System.out.println(solve(M, N));

		sc.close();
	}

	static int solve(int M, int N) {
		return M * N / 2;
	}
}
