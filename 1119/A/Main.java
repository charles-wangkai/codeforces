import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(solve(c));

		sc.close();
	}

	static int solve(int[] c) {
		int n = c.length;

		int rightIndex = n - 1;
		while (c[rightIndex] == c[0]) {
			rightIndex--;
		}

		int leftIndex = 0;
		while (c[leftIndex] == c[n - 1]) {
			leftIndex++;
		}

		return Math.max(rightIndex, n - leftIndex - 1);
	}
}
