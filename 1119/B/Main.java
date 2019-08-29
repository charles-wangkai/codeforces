import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int h = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, h));

		sc.close();
	}

	static int solve(int[] a, int h) {
		List<Integer> heights = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			heights.add(a[i]);
			Collections.sort(heights, Collections.reverseOrder());

			if (IntStream.range(0, (heights.size() + 1) / 2).mapToLong(j -> heights.get(j * 2)).sum() > h) {
				return heights.size() - 1;
			}
		}

		return heights.size();
	}
}
