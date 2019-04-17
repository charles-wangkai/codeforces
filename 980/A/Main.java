import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String s) {
		int pearlNum = (int) s.chars().filter(ch -> ch == 'o').count();
		int linkNum = s.length() - pearlNum;

		return pearlNum == 0 || linkNum % pearlNum == 0;
	}
}
