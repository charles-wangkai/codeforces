import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] answers = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				answers[i][j] = line.charAt(j);
			}
		}
		int[] a = new int[m];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(answers, a));

		sc.close();
	}

	static int solve(char[][] answers, int[] a) {
		int n = answers.length;
		int m = answers[0].length;

		int result = 0;
		for (int j = 0; j < m; j++) {
			Map<Character, Integer> answerToCount = new HashMap<>();
			for (int i = 0; i < n; i++) {
				answerToCount.put(answers[i][j], answerToCount.getOrDefault(answers[i][j], 0) + 1);
			}

			result += answerToCount.values().stream().mapToInt(x -> x).max().getAsInt() * a[j];
		}

		return result;
	}
}
