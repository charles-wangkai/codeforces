import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(solve(x, y, z, a, b, c) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int x, int y, int z, int a, int b, int c) {
		return x <= a && x + y <= a + b && x + y + z <= a + b + c;
	}
}
