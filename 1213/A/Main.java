import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(x));

		sc.close();
	}

	static int solve(int[] x) {
		return (int) Math.min(Arrays.stream(x).filter(xi -> xi % 2 == 0).count(),
				Arrays.stream(x).filter(xi -> xi % 2 == 1).count());
	}
}
