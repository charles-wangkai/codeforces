import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] id = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = sc.nextInt();
		}
		System.out.println(solve(id, k));

		sc.close();
	}

	static String solve(int[] id, int k) {
		Set<Integer> set = new HashSet<>();
		Deque<Integer> deque = new LinkedList<>();
		for (int x : id) {
			if (!set.contains(x)) {
				if (deque.size() == k) {
					set.remove(deque.pollLast());
				}

				set.add(x);
				deque.offerFirst(x);
			}
		}

		return String.format("%d\n%s", deque.size(),
				deque.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}
