import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] c = new int[5];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(solve(c));

		sc.close();
	}

	static int solve(int[] c) {
		int sum = Arrays.stream(c).sum();
		return (sum > 0 && sum % c.length == 0) ? sum / c.length : -1;
	}
}
