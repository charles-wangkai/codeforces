import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		int r = sc.nextInt();
		int a = sc.nextInt();
		System.out.println(solve(l, r, a));

		sc.close();
	}

	static int solve(int l, int r, int a) {
		int fill = Math.min(Math.abs(l - r), a);
		return (Math.min(l, r) + fill + (a - fill) / 2) * 2;
	}
}
