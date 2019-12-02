import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		List<Integer> eventNums = new ArrayList<>();
		Set<Integer> left = new HashSet<>();
		Set<Integer> entered = new HashSet<>();
		int eventNum = 0;
		for (int ai : a) {
			if (ai > 0) {
				if (left.contains(ai) || entered.contains(ai)) {
					return "-1";
				}

				entered.add(ai);
			} else {
				if (!entered.contains(-ai)) {
					return "-1";
				}

				entered.remove(-ai);
				left.add(-ai);
			}

			eventNum++;

			if (entered.isEmpty()) {
				eventNums.add(eventNum);
				left.clear();
				entered.clear();
				eventNum = 0;
			}
		}

		if (eventNum != 0) {
			return "-1";
		}

		return String.format("%d\n%s", eventNums.size(),
				eventNums.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}
