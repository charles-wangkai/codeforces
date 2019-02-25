import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static char solve(int n) {
		StringBuilder s = new StringBuilder();
		for (int i = 1; s.length() < n; i++) {
			s.append(i);
		}
		return s.charAt(n - 1);
	}
}
