import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		int d3 = sc.nextInt();
		System.out.println(solve(d1, d2, d3));

		sc.close();
	}

	static int solve(int d1, int d2, int d3) {
		if (d1 > d2) {
			return solve(d2, d1, d3);
		}

		return d1 + Math.min(d1 + d2, d3) + Math.min(d2, d1 + d3);
	}
}
