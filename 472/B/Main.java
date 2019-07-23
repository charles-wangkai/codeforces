import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] f = new int[n];
		for (int i = 0; i < f.length; i++) {
			f[i] = sc.nextInt();
		}
		System.out.println(solve(f, k));

		sc.close();
	}

	static int solve(int[] f, int k) {
		int[] sorted = Arrays.stream(f).boxed().sorted().mapToInt(x -> x).toArray();

		int result = 0;
		for (int i = f.length - 1; i >= 0; i -= k) {
			result += (sorted[i] - 1) * 2;
		}
		return result;
	}
}
