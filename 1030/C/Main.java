import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int[] a = sc.next().chars().map(ch -> ch - '0').toArray();
		System.out.println(solve(a) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] a) {
		int total = Arrays.stream(a).sum();

		for (int i = 2; i <= a.length; i++) {
			if (total % i == 0 && canDivide(a, total / i)) {
				return true;
			}
		}

		return false;
	}

	static boolean canDivide(int[] a, int segmentSum) {
		int sum = 0;
		for (int ai : a) {
			sum += ai;

			if (sum > segmentSum) {
				return false;
			}

			if (sum == segmentSum) {
				sum = 0;
			}
		}

		return true;
	}
}
