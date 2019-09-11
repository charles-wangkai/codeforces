import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		System.out.print(solve(n, b));

		sc.close();
	}

	static String solve(int n, int[] b) {
		int[] result = new int[n];
		for (int bi : b) {
			for (int i = bi - 1; i < result.length && result[i] == 0; i++) {
				result[i] = bi;
			}
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
