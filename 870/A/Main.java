import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] b = readArray(sc, m);
		System.out.println(solve(a, b));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int[] a, int[] b) {
		Set<Integer> setA = Arrays.stream(a).boxed().collect(Collectors.toSet());
		Set<Integer> setB = Arrays.stream(b).boxed().collect(Collectors.toSet());

		for (int result = 1;; result++) {
			if (isContain(result, setA) && isContain(result, setB)) {
				return result;
			}
		}
	}

	static boolean isContain(int x, Set<Integer> digits) {
		return String.valueOf(x).chars().anyMatch(ch -> digits.contains(ch - '0'));
	}
}
