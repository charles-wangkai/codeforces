import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		System.out.println(solve(a, b, c, x, y, z) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(int a, int b, int c, int x, int y, int z) {
		int less = Math.max(0, x - a) + Math.max(0, y - b) + Math.max(0, z - c);
		int greater = Math.max(0, a - x) / 2 + Math.max(0, b - y) / 2 + Math.max(0, c - z) / 2;

		return greater >= less;
	}
}
