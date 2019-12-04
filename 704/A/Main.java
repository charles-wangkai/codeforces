import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] types = new int[q];
		int[] arguments = new int[q];
		for (int i = 0; i < q; i++) {
			types[i] = sc.nextInt();
			arguments[i] = sc.nextInt();
		}
		System.out.println(solve(n, types, arguments));

		sc.close();
	}

	static String solve(int n, int[] types, int[] arguments) {
		List<Integer> result = new ArrayList<>();
		int unread = 0;
		int maxReadForType3 = 0;

		@SuppressWarnings("unchecked")
		Set<Integer>[] timesInApplication = new Set[n + 1];
		for (int i = 1; i < timesInApplication.length; i++) {
			timesInApplication[i] = new HashSet<>();
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int time = 0; time < types.length; time++) {
			if (types[time] == 1) {
				unread++;
				timesInApplication[arguments[time]].add(time);
				queue.offer(time);
			} else if (types[time] == 2) {
				unread -= timesInApplication[arguments[time]].size();
				timesInApplication[arguments[time]].clear();
			} else {
				int count = Math.max(0, arguments[time] - maxReadForType3);
				maxReadForType3 += count;

				for (int i = 0; i < count; i++) {
					int readTime = queue.poll();

					if (timesInApplication[arguments[readTime]].contains(readTime)) {
						unread--;
						timesInApplication[arguments[readTime]].remove(readTime);
					}
				}
			}

			result.add(unread);
		}

		return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}
}
