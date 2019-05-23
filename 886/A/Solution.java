import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int a3 = sc.nextInt();
		int a4 = sc.nextInt();
		int a5 = sc.nextInt();
		int a6 = sc.nextInt();
		System.out.println(solve(a1, a2, a3, a4, a5, a6) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int a1, int a2, int a3, int a4, int a5, int a6) {
		int[] scores = { a1, a2, a3, a4, a5, a6 };
		int sum = Arrays.stream(scores).sum();

		for (int i = 0; i < scores.length; i++) {
			for (int j = i + 1; j < scores.length; j++) {
				for (int k = j + 1; k < scores.length; k++) {
					if ((scores[i] + scores[j] + scores[k]) * 2 == sum) {
						return true;
					}
				}
			}
		}

		return false;
	}
}
