import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = readArray(sc, n);
			int[] b = readArray(sc, m);

			System.out.println(solve(a, b));
		}

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; ++i) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static long solve(int[] a, int[] b) {
		long result = 0;
		Set<Integer> tops = new HashSet<>();
		int indexA = 0;
		for (int bi : b) {
			if (tops.contains(bi)) {
				tops.remove(bi);
				++result;
			} else {
				while (a[indexA] != bi) {
					tops.add(a[indexA]);
					++indexA;
				}

				++indexA;
				result += 2 * tops.size() + 1;
			}
		}

		return result;
	}
}
