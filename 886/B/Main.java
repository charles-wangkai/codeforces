import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
		int result = -1;
		Set<Integer> seen = new HashSet<>();
		for (int i = a.length - 1; i >= 0; i--) {
			if (!seen.contains(a[i])) {
				result = a[i];
				seen.add(a[i]);
			}
		}

		return result;
	}
}
