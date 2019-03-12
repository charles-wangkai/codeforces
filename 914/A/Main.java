import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		return Arrays.stream(a).filter(x -> !isPerfectSquare(x)).max().getAsInt();
	}

	static boolean isPerfectSquare(int x) {
		if (x < 0) {
			return false;
		}

		int root = (int) Math.round(Math.sqrt(x));
		return root * root == x;
	}
}
