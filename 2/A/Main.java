import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Round[] rounds = new Round[n];
		for (int i = 0; i < rounds.length; i++) {
			String name = sc.next();
			int score = sc.nextInt();

			rounds[i] = new Round(name, score);
		}
		System.out.println(solve(rounds));

		sc.close();
	}

	static String solve(Round[] rounds) {
		Map<String, Integer> nameToTotal = new HashMap<>();
		for (Round round : rounds) {
			nameToTotal.put(round.name, nameToTotal.getOrDefault(round.name, 0) + round.score);
		}

		int maxTotal = nameToTotal.values().stream().mapToInt(x -> x).max().getAsInt();
		Set<String> candidates = nameToTotal.keySet().stream().filter(name -> nameToTotal.get(name) == maxTotal)
				.collect(Collectors.toSet());

		if (candidates.size() == 1) {
			return candidates.iterator().next();
		}

		nameToTotal.clear();
		for (int i = 0;; i++) {
			nameToTotal.put(rounds[i].name, nameToTotal.getOrDefault(rounds[i].name, 0) + rounds[i].score);

			if (candidates.contains(rounds[i].name) && nameToTotal.get(rounds[i].name) >= maxTotal) {
				return rounds[i].name;
			}
		}
	}
}

class Round {
	String name;
	int score;

	Round(String name, int score) {
		this.name = name;
		this.score = score;
	}
}