import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();

			System.out.println(solve(a, b, c));
		}

		sc.close();
	}

	static long solve(long a, long b, long c) {
		return Math.max(Math.max(computeCandyNum(a, b, c), computeCandyNum(b, c, a)), computeCandyNum(c, a, b));
	}

	static long computeCandyNum(long pile1, long pile2, long pile3) {
		long minPile = Math.min(pile1, pile2);
		long diff = Math.abs(pile1 - pile2);

		if (pile3 < diff) {
			return minPile + pile3;
		} else {
			return minPile + diff + (pile3 - diff) / 2;
		}
	}
}
