import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(solve(a, b, c));

		sc.close();
	}

	static int solve(int a, int b, int c) {
		int[] sides = { a, b, c };
		Arrays.sort(sides);

		return Math.max(0, sides[2] - sides[0] - sides[1] + 1);
	}
}
