import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] a) {
		long sum = Arrays.stream(a).asLongStream().sum();
		int max = Arrays.stream(a).max().getAsInt();

		return sum % 2 == 0 && max * 2 <= sum;
	}
}
