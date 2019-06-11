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
		Arrays.stream(solve(a)).forEach(System.out::println);

		sc.close();
	}

	static int[] solve(int[] a) {
		int[] result = new int[a.length];
		int winner = 2;
		for (int i = 0; i < result.length; i++) {
			if (a[i] % 2 == 0) {
				winner = 3 - winner;
			}

			result[i] = winner;
		}
		return result;
	}
}
