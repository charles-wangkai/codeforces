import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		System.out.println(solve(p));

		sc.close();
	}

	static double solve(int[] p) {
		return Arrays.stream(p).average().getAsDouble();
	}
}
