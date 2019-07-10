import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
		Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
		for (int i = 1;; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
	}
}
