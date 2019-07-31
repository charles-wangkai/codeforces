import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt();
		int L = sc.nextInt();
		System.out.println(solve(H, L));

		sc.close();
	}

	static double solve(int H, int L) {
		return ((long) L * L - (long) H * H) / (2.0 * H);
	}
}
