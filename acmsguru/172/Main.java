import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] pupils = new int[M][2];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 2; j++) {
				pupils[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(N, pupils));

		sc.close();
	}

	static String solve(int N, int[][] pupils) {
		@SuppressWarnings("unchecked")
		List<Integer>[] adjLists = new List[N + 1];
		for (int i = 1; i < adjLists.length; i++) {
			adjLists[i] = new ArrayList<>();
		}

		for (int[] pupil : pupils) {
			adjLists[pupil[0]].add(pupil[1]);
			adjLists[pupil[1]].add(pupil[0]);
		}

		int[] days = new int[N + 1];
		for (int i = 1; i < days.length; i++) {
			if (days[i] == 0 && !fill(adjLists, days, i, 1)) {
				return "no";
			}
		}

		int[] numbers = IntStream.range(1, days.length).filter(i -> days[i] == 1).toArray();
		return String.format("yes\n%d\n%s", numbers.length,
				Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}

	static boolean fill(List<Integer>[] adjLists, int[] days, int index, int value) {
		if (days[index] != 0) {
			return days[index] == value;
		}

		days[index] = value;

		for (int adj : adjLists[index]) {
			if (!fill(adjLists, days, adj, -value)) {
				return false;
			}
		}

		return true;
	}
}
