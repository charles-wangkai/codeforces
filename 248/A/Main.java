import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] l = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		System.out.println(solve(l, r));

		sc.close();
	}

	static int solve(int[] l, int[] r) {
		return computeTime(l) + computeTime(r);
	}

	static int computeTime(int[] doors) {
		int zeroCount = (int) Arrays.stream(doors).filter(x -> x == 0).count();
		return Math.min(zeroCount, doors.length - zeroCount);
	}
}
