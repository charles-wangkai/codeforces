import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(a, b));

		sc.close();
	}

	static int solve(int a, int b) {
		int distance = Math.abs(a - b);
		return computeTiredness(distance / 2) + computeTiredness(distance - distance / 2);
	}

	static int computeTiredness(int step) {
		return step * (step + 1) / 2;
	}
}
