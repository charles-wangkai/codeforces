import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[2 * n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static long solve(int[] a) {
		int n = a.length / 2;

		@SuppressWarnings("unchecked")
		List<Integer>[] indexLists = new List[n + 1];
		for (int i = 0; i < indexLists.length; i++) {
			indexLists[i] = new ArrayList<>();
		}
		indexLists[0].add(0);
		indexLists[0].add(0);

		for (int i = 0; i < a.length; i++) {
			indexLists[a[i]].add(i);
		}

		return IntStream.rangeClosed(1, n).mapToLong(i -> Math.abs(indexLists[i].get(0) - indexLists[i - 1].get(0))
				+ Math.abs(indexLists[i].get(1) - indexLists[i - 1].get(1))).sum();
	}
}
