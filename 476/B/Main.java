import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(solve(s1, s2));

		sc.close();
	}

	static double solve(String s1, String s2) {
		int plusNum1 = count(s1, '+');
		int plusNum2 = count(s2, '+');
		int questionNum2 = count(s2, '?');

		return (double) choose(questionNum2, plusNum1 - plusNum2) / (1 << questionNum2);
	}

	static int count(String s, char target) {
		return (int) s.chars().filter(ch -> ch == target).count();
	}

	static int choose(int n, int m) {
		if (m < 0 || m > n) {
			return 0;
		}

		int result = 1;
		for (int i = 0; i < m; i++) {
			result = result * (n - i) / (i + 1);
		}
		return result;
	}
}
