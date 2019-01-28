import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		Map<Integer, Queue<Integer>> valueToIndices = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (!valueToIndices.containsKey(a[i])) {
				valueToIndices.put(a[i], new LinkedList<>());
			}

			valueToIndices.get(a[i]).offer(i);
		}

		int pairSum = Arrays.stream(a).sum() / (a.length / 2);
		StringBuilder result = new StringBuilder();
		while (!valueToIndices.isEmpty()) {
			int value1 = valueToIndices.keySet().iterator().next();
			int index1 = valueToIndices.get(value1).poll();
			if (valueToIndices.get(value1).isEmpty()) {
				valueToIndices.remove(value1);
			}

			int value2 = pairSum - value1;
			int index2 = valueToIndices.get(value2).poll();
			if (valueToIndices.get(value2).isEmpty()) {
				valueToIndices.remove(value2);
			}

			result.append(String.format("%d %d\n", index1 + 1, index2 + 1));
		}
		return result.toString();
	}
}
