import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		int x = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(solve(c, l, r, x));

		sc.close();
	}

	static int solve(int[] c, int l, int r, int x) {
		return search(c, l, r, x, 0, new ArrayList<>());
	}

	static int search(int[] c, int l, int r, int x, int index, List<Integer> chosen) {
		if (index == c.length) {
			int total = chosen.stream().mapToInt(p -> p).sum();

			if (chosen.size() >= 2 && total >= l && total <= r && chosen.stream().mapToInt(p -> p).max().getAsInt()
					- chosen.stream().mapToInt(p -> p).min().getAsInt() >= x) {
				return 1;
			} else {
				return 0;
			}
		}

		int result = search(c, l, r, x, index + 1, chosen);

		chosen.add(c[index]);
		result += search(c, l, r, x, index + 1, chosen);
		chosen.remove(chosen.size() - 1);

		return result;
	}
}
