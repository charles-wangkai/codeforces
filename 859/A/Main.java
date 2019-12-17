import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int[] r = new int[K];
		for (int i = 0; i < r.length; i++) {
			r[i] = sc.nextInt();
		}
		System.out.println(solve(r));

		sc.close();
	}

	static int solve(int[] r) {
		return Math.max(0, Arrays.stream(r).max().getAsInt() - 25);
	}
}
