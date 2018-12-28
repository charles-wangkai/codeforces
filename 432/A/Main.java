import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] y = new int[n];
		for (int i = 0; i < y.length; i++) {
			y[i] = sc.nextInt();
		}
		System.out.println(solve(y, k));

		sc.close();
	}

	static int solve(int[] y, int k) {
		return (int) Arrays.stream(y).filter(x -> x <= 5 - k).count() / 3;
	}
}
