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
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		List<String> result = new ArrayList<>();
		int additive = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			int x = subtractMod(i, a[i] + additive, a.length);
			result.add(String.format("1 %d %d", i + 1, x));

			additive = addMod(additive, x, a.length);
		}
		result.add(String.format("2 %d %d", a.length, a.length));

		return String.format("%d\n%s", result.size(), String.join("\n", result));
	}

	static int addMod(int a, int b, int m) {
		return ((a + b) % m + m) % m;
	}

	static int subtractMod(int a, int b, int m) {
		return addMod(a, -b, m);
	}
}
