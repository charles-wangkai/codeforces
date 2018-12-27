import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		int x3 = sc.nextInt();
		System.out.println(solve(x1, x2, x3));

		sc.close();
	}

	static int solve(int x1, int x2, int x3) {
		return Arrays.stream(new int[] { x1, x2, x3 }).max().getAsInt()
				- Arrays.stream(new int[] { x1, x2, x3 }).min().getAsInt();
	}
}
