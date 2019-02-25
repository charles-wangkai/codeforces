import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static final int[] DIVISORS = { 2, 3 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(int[] a) {
		return Arrays.stream(a).map(Main::regulate).boxed().collect(Collectors.toSet()).size() == 1;
	}

	static int regulate(int x) {
		for (int divisor : DIVISORS) {
			while (x % divisor == 0) {
				x /= divisor;
			}
		}
		return x;
	}
}
