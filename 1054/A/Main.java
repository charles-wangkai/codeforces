import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		int t1 = sc.nextInt();
		int t2 = sc.nextInt();
		int t3 = sc.nextInt();
		System.out.println(solve(x, y, z, t1, t2, t3) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int x, int y, int z, int t1, int t2, int t3) {
		return (Math.abs(z - x) + Math.abs(y - x)) * t2 + 3 * t3 <= Math.abs(y - x) * t1;
	}
}
