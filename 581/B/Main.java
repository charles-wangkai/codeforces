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
		System.out.println(String.join(" ", Arrays.stream(solve(h)).mapToObj(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static int[] solve(int[] h) {
		int[] result = new int[h.length];
		int max = -1;
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = Math.max(0, max + 1 - h[i]);

			max = Math.max(max, h[i]);
		}
		return result;
	}
}
