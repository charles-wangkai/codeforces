import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String recipe = sc.next();
		int nb = sc.nextInt();
		int ns = sc.nextInt();
		int nc = sc.nextInt();
		int pb = sc.nextInt();
		int ps = sc.nextInt();
		int pc = sc.nextInt();
		long r = sc.nextLong();
		System.out.println(solve(recipe, nb, ns, nc, pb, ps, pc, r));

		sc.close();
	}

	static long solve(String recipe, int nb, int ns, int nc, int pb, int ps, int pc, long r) {
		int ub = 0;
		int us = 0;
		int uc = 0;
		for (char ch : recipe.toCharArray()) {
			if (ch == 'B') {
				ub++;
			} else if (ch == 'S') {
				us++;
			} else {
				uc++;
			}
		}

		long result = -1;
		long lower = 0;
		long upper = 10_000_000_000_000L;
		while (lower <= upper) {
			long middle = (lower + upper) / 2;

			if (isValid(ub, us, uc, nb, ns, nc, pb, ps, pc, r, middle)) {
				result = middle;

				lower = middle + 1;
			} else {
				upper = middle - 1;
			}
		}

		return result;
	}

	static boolean isValid(int ub, int us, int uc, int nb, int ns, int nc, int pb, int ps, int pc, long r, long count) {
		return Math.max(0, count * ub - nb) * pb + Math.max(0, count * us - ns) * ps
				+ Math.max(0, count * uc - nc) * pc <= r;
	}
}
