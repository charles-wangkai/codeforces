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
		int maxLength = 1;
		int length = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] <= a[i - 1] * 2) {
				length++;
			} else {
				length = 1;
			}

			maxLength = Math.max(maxLength, length);
		}
		return maxLength;
	}
}
