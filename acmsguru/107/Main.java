import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static final int PLACE_LIMIT = 9;
	static final int PLACE_VALUE_LIMIT = 1_000_000_000;
	static final int TARGET_SQUARE_TAIL = 987_654_321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		System.out.println(solve(N));

		sc.close();
	}

	static String solve(int N) {
		Set<Integer> tails = new HashSet<>();
		search(tails, 1, 0);

		if (N <= PLACE_LIMIT) {
			return String.valueOf(tails.stream().filter(tail -> String.valueOf(tail).length() == N).count());
		} else {
			StringBuilder result = new StringBuilder(String.valueOf(tails.size() * 9));
			for (int i = 0; i < N - PLACE_LIMIT - 1; i++) {
				result.append('0');
			}
			return result.toString();
		}
	}

	static void search(Set<Integer> tails, int placeValue, int previous) {
		if (placeValue == PLACE_VALUE_LIMIT) {
			return;
		}

		for (int digit = 0; digit <= 9; digit++) {
			int current = digit * placeValue + previous;

			long square = (long) current * current;
			if (square / placeValue % 10 == TARGET_SQUARE_TAIL / placeValue % 10) {
				if (square % PLACE_VALUE_LIMIT == TARGET_SQUARE_TAIL) {
					tails.add(current);
				}

				search(tails, placeValue * 10, current);
			}
		}
	}
}
