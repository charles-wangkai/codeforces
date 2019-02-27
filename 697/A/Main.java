import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int s = sc.nextInt();
		int x = sc.nextInt();
		System.out.println(solve(t, s, x) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int t, int s, int x) {
		return x == t || (x >= t + s && (x - t) % s <= 1);
	}
}
