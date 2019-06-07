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
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		int count1 = (int) Arrays.stream(a).filter(x -> x == 1).count();
		int count2 = a.length - count1;

		return Math.min(count2, count1) + Math.max(0, count1 - count2) / 3;
	}
}
