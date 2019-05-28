import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int[] l = new int[n];
			int[] r = new int[n];
			for (int i = 0; i < n; i++) {
				l[i] = sc.nextInt();
				r[i] = sc.nextInt();
			}

			System.out.println(solve(l, r));
		}

		sc.close();
	}

	static String solve(int[] l, int[] r) {
		Range[] ranges = new Range[l.length];
		for (int i = 0; i < ranges.length; i++) {
			ranges[i] = new Range(i, l[i], r[i]);
		}

		Arrays.sort(ranges, (range1, range2) -> Integer.compare(range1.l, range2.l));

		int[] groups = new int[ranges.length];
		int group = 1;
		int maxRight = -1;
		for (Range range : ranges) {
			if (group == 1) {
				if (maxRight >= 0 && range.l > maxRight) {
					group = 2;
				} else {
					maxRight = Math.max(maxRight, range.r);
				}
			}

			groups[range.index] = group;
		}

		if (group == 1) {
			return "-1";
		}

		return Arrays.stream(groups).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}

class Range {
	int index;
	int l;
	int r;

	Range(int index, int l, int r) {
		this.index = index;
		this.l = l;
		this.r = r;
	}
}