import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] tiles = new String[3];
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = sc.next();
		}
		System.out.println(solve(tiles));

		sc.close();
	}

	static int solve(String[] tiles) {
		Map<String, Integer> tileToCount = new HashMap<>();
		for (String tile : tiles) {
			tileToCount.put(tile, tileToCount.getOrDefault(tile, 0) + 1);
		}

		int result = 3 - tileToCount.values().stream().mapToInt(x -> x).max().getAsInt();

		Set<String> tileSet = Arrays.stream(tiles).collect(Collectors.toSet());

		for (char suit : new char[] { 'm', 'p', 's' }) {
			for (int digit = 1; digit <= 7; digit++) {
				result = Math.min(result, computeDrawNum(tileSet, suit, digit));
			}
		}

		return result;
	}

	static int computeDrawNum(Set<String> tileSet, char suit, int digit) {
		return (int) IntStream.range(0, 3).filter(i -> !tileSet.contains(String.format("%d%c", digit + i, suit)))
				.count();
	}
}
