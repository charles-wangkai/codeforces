import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s) {
		int countA = (int) s.chars().filter(ch -> ch == 'a').count();
		int countC = (int) s.chars().filter(ch -> ch == 'c').count();
		int countB = s.length() - countA - countC;

		return s.substring(0, countA).chars().allMatch(ch -> ch == 'a')
				&& s.substring(s.length() - countC).chars().allMatch(ch -> ch == 'c')
				&& (countC == countA || countC == countB) && countA != 0 && countB != 0;
	}
}
