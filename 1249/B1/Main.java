import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int[] p = new int[n];
			for (int i = 0; i < p.length; i++) {
				p[i] = sc.nextInt();
			}

			System.out.println(solve(p));
		}

		sc.close();
	}

	static String solve(int[] p) {
		int[] dayNums = IntStream.range(0, p.length).map(i -> -1).toArray();

		for (int i = 0; i < dayNums.length; i++) {
			if (dayNums[i] == -1) {
				Set<Integer> indices = new HashSet<>();

				int index = i;
				while (!indices.contains(index)) {
					indices.add(index);

					index = p[index] - 1;
				}

				for (int idx : indices) {
					dayNums[idx] = indices.size();
				}
			}
		}

		return Arrays.stream(dayNums).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
