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

	static String solve(int[] a) {
		int remain = Arrays.stream(a).sum();
		int index = 0;
		int offset = 1;
		StringBuilder result = new StringBuilder();
		while (remain != 0) {
			if (a[index] != 0) {
				a[index]--;
				remain--;
				result.append('P');
			}

			index += offset;
			if (index == -1 || index == a.length) {
				offset *= -1;
				index += offset * 2;
			}
			result.append((offset == 1) ? 'R' : 'L');
		}

		return result.toString();
	}
}
