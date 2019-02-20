import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, m));

		sc.close();
	}

	static int solve(int[] a, int m) {
		int maxTime = -1;
		int result = -1;
		for (int i = 0; i < a.length; i++) {
			int time = divideToCeil(a[i], m);

			if (time >= maxTime) {
				maxTime = time;
				result = i + 1;
			}
		}
		return result;
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
