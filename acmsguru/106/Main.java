
// https://blog.csdn.net/weixin_42373330/article/details/89848777

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y1 = sc.nextInt();
		int y2 = sc.nextInt();
		System.out.println(solve(a, b, c, x1, x2, y1, y2));

		sc.close();
	}

	static long solve(int a, int b, int c, int x1, int x2, int y1, int y2) {
		if (x1 > x2 || y1 > y2) {
			return 0;
		}

		if (a == 0 && b == 0) {
			if (c == 0) {
				return (x2 - x1 + 1L) * (y2 - y1 + 1);
			} else {
				return 0;
			}
		}
		if (a == 0) {
			return computeSolutionNumWithOneVar(b, c, y1, y2) * (x2 - x1 + 1);
		}
		if (b == 0) {
			return computeSolutionNumWithOneVar(a, c, x1, x2) * (y2 - y1 + 1);
		}

		int d = gcd(a, b);

		if (c % d != 0) {
			return 0;
		}

		int u = a / d;
		int v = b / d;
		int g = -c / d;

		ExtendGCDResult egr = extendGCD(-u, -v);

		long x0 = egr.x;
		long y0 = egr.y;

		Range xRange = computeRange(x1, x2, v, (int) (g * x0 % v));
		Range yRange = computeRange(y1, y2, u, (int) (g * y0 % u));

		Range xRangeByYRange = computeXRangeByYRange(a, b, c, yRange);

		return Math.max(0,
				(Math.min(xRange.max, xRangeByYRange.max) - Math.max(xRange.min, xRangeByYRange.min)) / Math.abs(v)
						+ 1);
	}

	static int computeSolutionNumWithOneVar(int coef, int c, int lower, int upper) {
		if (-c % coef != 0) {
			return 0;
		}

		int solution = -c / coef;
		return (solution >= lower && solution <= upper) ? 1 : 0;
	}

	static Range computeXRangeByYRange(int a, int b, int c, Range yRange) {
		long x1 = (-c - b * yRange.min) / a;
		long x2 = (-c - b * yRange.max) / a;

		return new Range(Math.min(x1, x2), Math.max(x1, x2));
	}

	static Range computeRange(int lower, int upper, int modulus, int remainder) {
		int min = lower / modulus * modulus + remainder;
		while (min >= lower) {
			min -= Math.abs(modulus);
		}
		while (min < lower) {
			min += Math.abs(modulus);
		}

		int max = upper / modulus * modulus + remainder;
		while (max <= upper) {
			max += Math.abs(modulus);
		}
		while (max > upper) {
			max -= Math.abs(modulus);
		}

		return new Range(min, max);
	}

	static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	static ExtendGCDResult extendGCD(long a, long b) {
		if (b == 0) {
			return new ExtendGCDResult(a, 1, 0);
		}

		ExtendGCDResult egr = extendGCD(b, a % b);
		return new ExtendGCDResult(egr.r, egr.y, egr.x - egr.y * (a / b));
	}
}

class Range {
	long min;
	long max;

	Range(long min, long max) {
		this.min = min;
		this.max = max;
	}
}

class ExtendGCDResult {
	long r;
	long x;
	long y;

	ExtendGCDResult(long r, long x, long y) {
		this.r = r;
		this.x = x;
		this.y = y;
	}
}
