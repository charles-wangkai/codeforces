import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		System.out.println(solve(l, p, q));

		sc.close();
	}

	static double solve(int l, int p, int q) {
		return (double) l / (p + q) * p;
	}
}
