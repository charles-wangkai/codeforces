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
		int maxLength = 0;
		int length = 0;
		for (int i = 0; i < a.length; i++) {
			if (i != 0 && a[i] >= a[i - 1]) {
				length++;
			} else {
				length = 1;
			}

			maxLength = Math.max(maxLength, length);
		}
		return maxLength;
	}
}
