import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] b = new int[n];
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		System.out.println(solve(b));

		sc.close();
	}

	static String solve(int[] b) {
		int min = Arrays.stream(b).min().getAsInt();
		int max = Arrays.stream(b).max().getAsInt();

		int diff = max - min;

		long wayNum;
		if (min == max) {
			wayNum = b.length * (b.length - 1L) / 2;
		} else {
			wayNum = (long) count(b, min) * count(b, max);
		}

		return String.format("%d %d", diff, wayNum);
	}

	static int count(int[] b, int target) {
		return (int) Arrays.stream(b).filter(x -> x == target).count();
	}
}
