import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int h = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, h, k));

		sc.close();
	}

	static long solve(int[] a, int h, int k) {
		long result = 0;
		int remain = 0;
		int index = 0;
		while (index < a.length) {
			int time = divideToCeil(Math.max(0, a[index] - (h - remain)), k);
			result += time;
			remain = Math.max(0, remain - time * k);

			while (index < a.length && remain + a[index] <= h) {
				remain += a[index];
				index++;
			}
		}

		result += divideToCeil(remain, k);

		return result;
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
