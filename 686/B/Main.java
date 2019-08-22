import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		List<String> segments = new ArrayList<>();
		while (true) {
			boolean changed = false;

			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;

					segments.add(String.format("%d %d", i + 1, i + 2));
					changed = true;
				}
			}

			if (!changed) {
				break;
			}
		}

		return String.join("\n", segments);
	}
}
