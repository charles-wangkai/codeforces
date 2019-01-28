import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] l = new int[N];
		for (int i = 0; i < l.length; i++) {
			l[i] = sc.nextInt();
		}
		System.out.print(solve(l));

		sc.close();
	}

	static String solve(int[] l) {
		Map<Integer, Integer> lengthToCount = new HashMap<>();
		for (int length : l) {
			lengthToCount.put(length, lengthToCount.getOrDefault(length, 0) + 1);
		}

		return String.format("%d %d\n", lengthToCount.values().stream().mapToInt(x -> x).max().getAsInt(),
				lengthToCount.size());
	}
}
