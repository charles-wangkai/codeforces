import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = sc.nextInt();
		}
		System.out.print(solve(t));

		sc.close();
	}

	static String solve(int[] t) {
		@SuppressWarnings("unchecked")
		List<Integer>[] indicesArray = new List[3];
		for (int i = 0; i < indicesArray.length; i++) {
			indicesArray[i] = new ArrayList<>();
		}

		for (int i = 0; i < t.length; i++) {
			indicesArray[t[i] - 1].add(i + 1);
		}

		StringBuilder result = new StringBuilder();
		int w = Arrays.stream(indicesArray).mapToInt(List::size).min().getAsInt();
		result.append(w).append("\n");

		for (int i = 0; i < w; i++) {
			result.append(buildTeam(indicesArray, i)).append("\n");
		}
		return result.toString();
	}

	static String buildTeam(List<Integer>[] indicesArray, int teamIndex) {
		return String.join(" ", Arrays.stream(indicesArray).map(indices -> String.valueOf(indices.get(teamIndex)))
				.toArray(String[]::new));
	}
}
