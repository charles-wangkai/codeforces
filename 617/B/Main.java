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

	static long solve(int[] a) {
		long result = 0;
		boolean hasFirst = false;
		int count0 = 0;
		for (int ai : a) {
			if (ai == 1) {
				if (hasFirst) {
					result *= count0 + 1;
				} else {
					result = 1;
				}

				count0 = 0;
				hasFirst = true;
			} else {
				count0++;
			}
		}
		return result;
	}
}
