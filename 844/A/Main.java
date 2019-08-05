import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int k = sc.nextInt();
		System.out.println(solve(s, k));

		sc.close();
	}

	static String solve(String s, int k) {
		return (k > s.length()) ? "impossible" : String.valueOf(Math.max(0, k - (int) s.chars().distinct().count()));
	}
}
