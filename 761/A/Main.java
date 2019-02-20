import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(a, b) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int a, int b) {
		return (a != 0 || b != 0) && Math.abs(a - b) <= 1;
	}
}
