import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		System.out.println(solve(N));

		sc.close();
	}

	static int solve(int N) {
		return (int) (N * (N + 1L) / 2 + 1);
	}
}
