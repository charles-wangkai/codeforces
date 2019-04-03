import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, m));

		sc.close();
	}

	static String solve(int[] a, int m) {
		Set<Integer> aSet = Arrays.stream(a).boxed().collect(Collectors.toSet());

		List<Integer> result = new ArrayList<>();
		for (int type = 1;; type++) {
			if (aSet.contains(type)) {
				continue;
			}

			if (m < type) {
				break;
			}

			result.add(type);
			m -= type;
		}

		return String.format("%d\n%s", result.size(),
				result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}
