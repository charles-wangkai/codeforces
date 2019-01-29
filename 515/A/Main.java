import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int s = sc.nextInt();
		System.out.println(solve(a, b, s) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(int a, int b, int s) {
		int extra = s - (Math.abs(a) + Math.abs(b));
		return extra >= 0 && extra % 2 == 0;
	}
}
