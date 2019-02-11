import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final String[] MUSCLES = { "chest", "biceps", "back" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		int[] sums = new int[MUSCLES.length];
		for (int i = 0; i < a.length; i++) {
			sums[i % sums.length] += a[i];
		}

		int maxSum = Arrays.stream(sums).max().getAsInt();
		return MUSCLES[IntStream.range(0, sums.length).filter(i -> sums[i] == maxSum).findAny().getAsInt()];
	}
}
