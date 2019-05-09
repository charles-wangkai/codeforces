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
		int n = a.length;

		boolean[] collected = new boolean[n];
		int result = 0;
		int index = -1;
		int offset = 1;
		int collectNum = 0;
		while (collectNum != n) {
			index += offset;

			if (index == -1 || index == n) {
				result++;
				offset *= -1;
				index += offset * 2;
			}

			if (!collected[index] && collectNum >= a[index]) {
				collected[index] = true;
				collectNum++;
			}
		}
		return result;
	}
}
