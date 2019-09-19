import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < words.length; i++) {
			words[i] = sc.next();
		}
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int[][] groups = new int[k][];
		for (int i = 0; i < groups.length; i++) {
			int x = sc.nextInt();

			groups[i] = new int[x];
			for (int j = 0; j < groups[i].length; j++) {
				groups[i][j] = sc.nextInt() - 1;
			}
		}
		String[] messageWords = new String[m];
		for (int i = 0; i < messageWords.length; i++) {
			messageWords[i] = sc.next();
		}
		System.out.println(solve(words, a, groups, messageWords));

		sc.close();
	}

	static long solve(String[] words, int[] a, int[][] groups, String[] messageWords) {
		int[] minGroupCosts = Arrays.stream(groups)
				.mapToInt(group -> Arrays.stream(group).map(i -> a[i]).min().getAsInt()).toArray();

		Map<String, Integer> wordToGroup = new HashMap<>();
		for (int i = 0; i < groups.length; i++) {
			for (int index : groups[i]) {
				wordToGroup.put(words[index], i);
			}
		}

		return Arrays.stream(messageWords).mapToLong(word -> minGroupCosts[wordToGroup.get(word)]).sum();
	}
}
