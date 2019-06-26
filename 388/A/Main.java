import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(x));

		sc.close();
	}

	static int solve(int[] x) {
		int[] sorted = Arrays.stream(x).boxed().sorted().mapToInt(p -> p).toArray();

		boolean[] used = new boolean[x.length];
		int result = 0;
		while (true) {
			int length = 0;
			for (int i = 0; i < used.length; i++) {
				if (!used[i] && sorted[i] >= length) {
					used[i] = true;
					length++;
				}
			}

			if (length == 0) {
				break;
			}

			result++;
		}
		return result;
	}
}
