import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Interval[] intervals = new Interval[N];
		for (int i = 0; i < intervals.length; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			intervals[i] = new Interval(A, B);
		}
		System.out.println(solve(intervals));

		sc.close();
	}

	static int solve(Interval[] intervals) {
		Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1.A, interval2.A));

		int result = 0;
		int maxB = -1;
		for (Interval interval : intervals) {
			if (interval.B < maxB) {
				result++;
			} else {
				maxB = interval.B;
			}
		}
		return result;
	}
}

class Interval {
	int A;
	int B;

	Interval(int a, int b) {
		A = a;
		B = b;
	}
}