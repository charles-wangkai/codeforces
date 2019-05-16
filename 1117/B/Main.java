import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, m, k));

		sc.close();
	}

	static long solve(int[] a, int m, int k) {
		int[] sortedA = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		int maxValue = sortedA[sortedA.length - 1];
		int secondMaxValue = sortedA[sortedA.length - 2];

		return m / (k + 1L) * ((long) k * maxValue + secondMaxValue) + m % (k + 1L) * maxValue;
	}
}
