import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] d = new int[n];
		for (int i = 0; i < d.length; i++) {
			d[i] = sc.nextInt();
		}
		System.out.println(solve(d));

		sc.close();
	}

	static String solve(int[] d) {
		SortedMap<Integer, Integer> divisorToCount = new TreeMap<>();
		for (int divisor : d) {
			divisorToCount.put(divisor, divisorToCount.getOrDefault(divisor, 0) + 1);
		}

		int x = divisorToCount.lastKey();

		for (int i = 1; i <= x; i++) {
			if (x % i == 0) {
				divisorToCount.put(i, divisorToCount.get(i) - 1);

				if (divisorToCount.get(i) == 0) {
					divisorToCount.remove(i);
				}
			}
		}

		int y = divisorToCount.lastKey();

		return String.format("%d %d", x, y);
	}
}
