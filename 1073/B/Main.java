import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] b = readArray(sc, n);
		System.out.println(Arrays.stream(solve(a, b)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int[] solve(int[] a, int[] b) {
		Set<Integer> moved = new HashSet<>();
		int indexA = 0;
		int[] result = new int[b.length];
		for (int i = 0; i < result.length; i++) {
			while (!moved.contains(b[i])) {
				moved.add(a[indexA]);

				indexA++;
				result[i]++;
			}
		}
		return result;
	}
}
