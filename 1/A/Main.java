import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		System.out.println(solve(n, m, a));

		sc.close();
	}

	static long solve(int n, int m, int a) {
		return divideToCeil(n, a) * divideToCeil(m, a);
	}

	static long divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
