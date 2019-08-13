import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		List<String> swaps = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			int indexWithMin = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[indexWithMin]) {
					indexWithMin = j;
				}
			}

			if (indexWithMin != i) {
				swaps.add(String.format("%d %d", i, indexWithMin));

				int temp = a[i];
				a[i] = a[indexWithMin];
				a[indexWithMin] = temp;
			}
		}

		return String.format("%d\n%s", swaps.size(), swaps.stream().collect(Collectors.joining("\n")));
	}
}
