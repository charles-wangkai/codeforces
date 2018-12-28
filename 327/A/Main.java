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
		int maxOneNum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				flip(a, i, j);

				maxOneNum = Math.max(maxOneNum, (int) Arrays.stream(a).filter(x -> x == 1).count());

				flip(a, i, j);
			}
		}
		return maxOneNum;
	}

	static void flip(int[] a, int beginIndex, int endIndex) {
		for (int i = beginIndex; i <= endIndex; i++) {
			a[i] = 1 - a[i];
		}
	}
}
