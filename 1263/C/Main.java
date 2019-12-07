import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();

			System.out.println(solve(n));
		}

		sc.close();
	}

	static String solve(int n) {
		List<Integer> ratingIncrements = new ArrayList<>();
		ratingIncrements.add(0);

		while (true) {
			int lower = ratingIncrements.get(ratingIncrements.size() - 1) + 1;

			int next = n / (n / lower);
			ratingIncrements.add(next);

			if (next == n) {
				break;
			}
		}

		return String.format("%d\n%s", ratingIncrements.size(),
				ratingIncrements.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}
