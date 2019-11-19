import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, k));

		sc.close();
	}

	static int solve(int[] a, int k) {
		int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		Set<Integer> subset = new HashSet<>();
		for (int x : sorted) {
			if (x % k != 0 || !subset.contains(x / k)) {
				subset.add(x);
			}
		}

		return subset.size();
	}
}
