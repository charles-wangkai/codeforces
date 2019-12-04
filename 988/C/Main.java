import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int[][] sequences = new int[k][];
		for (int i = 0; i < sequences.length; i++) {
			int n = sc.nextInt();
			sequences[i] = new int[n];
			for (int j = 0; j < sequences[i].length; j++) {
				sequences[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(sequences));

		sc.close();
	}

	static String solve(int[][] sequences) {
		Map<Integer, Map<Integer, Integer>> sumToPosition = new HashMap<>();
		for (int i = 0; i < sequences.length; i++) {
			int total = Arrays.stream(sequences[i]).sum();

			for (int j = 0; j < sequences[i].length; j++) {
				int sum = total - sequences[i][j];
				if (!sumToPosition.containsKey(sum)) {
					sumToPosition.put(sum, new HashMap<>());
				}

				Map<Integer, Integer> position = sumToPosition.get(sum);
				position.put(i, j);

				if (position.size() == 2) {
					return String.format("YES\n%s",
							position.entrySet().stream()
									.map(entry -> String.format("%d %d", entry.getKey() + 1, entry.getValue() + 1))
									.collect(Collectors.joining("\n")));
				}
			}
		}

		return "NO";
	}
}
