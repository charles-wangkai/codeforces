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
		a = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		int result = 0;
		int lower = 1;
		for (int ai : a) {
			if (ai + 1 < lower) {
				continue;
			}

			if (ai - 1 >= lower) {
				lower = ai;
			} else if (ai >= lower) {
				lower = ai + 1;
			} else {
				lower = ai + 2;
			}

			result++;
		}

		return result;
	}
}
