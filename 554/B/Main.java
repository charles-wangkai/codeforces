import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[][] squares = new char[n][];
		for (int r = 0; r < n; r++) {
			squares[r] = sc.next().toCharArray();
		}
		System.out.println(solve(squares));

		sc.close();
	}

	static int solve(char[][] squares) {
		Map<String, Integer> rowToCount = new HashMap<>();
		for (int r = 0; r < squares.length; r++) {
			String row = new String(squares[r]);

			rowToCount.put(row, rowToCount.getOrDefault(row, 0) + 1);
		}

		return rowToCount.values().stream().mapToInt(x -> x).max().getAsInt();
	}
}
