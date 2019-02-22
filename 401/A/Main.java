import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		System.out.println(solve(numbers, x));

		sc.close();
	}

	static int solve(int[] numbers, int x) {
		return divideToCeil(Math.abs(Arrays.stream(numbers).sum()), x);
	}

	static int divideToCeil(int a, int b) {
		return a / b + (a % b == 0 ? 0 : 1);
	}
}
