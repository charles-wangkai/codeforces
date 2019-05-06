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
		System.out.println(solve(a) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] a) {
		int[] distinctSorted = Arrays.stream(a).distinct().sorted().toArray();

		return distinctSorted.length <= 2
				|| (distinctSorted.length == 3 && distinctSorted[0] + distinctSorted[2] == distinctSorted[1] * 2);
	}
}
