import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(solve(n, r));

		sc.close();
	}

	static double solve(int n, int r) {
		return r * Math.sin(Math.PI / n) / (1 - Math.sin(Math.PI / n));
	}
}
