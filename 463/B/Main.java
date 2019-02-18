import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] h = new int[n];
		for (int i = 0; i < h.length; i++) {
			h[i] = sc.nextInt();
		}
		System.out.println(solve(h));

		sc.close();
	}

	static int solve(int[] h) {
		return Arrays.stream(h).max().getAsInt();
	}
}
