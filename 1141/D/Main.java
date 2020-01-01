import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String l = sc.next();
		String r = sc.next();
		System.out.println(solve(l, r));

		sc.close();
	}

	static String solve(String l, String r) {
		Map<Character, List<Integer>> leftColorToIndices = buildColorToIndices(l);
		Map<Character, List<Integer>> rightColorToIndices = buildColorToIndices(r);

		List<String> pairs = new ArrayList<>();
		for (char color : new ArrayList<>(leftColorToIndices.keySet())) {
			if (color != '?') {
				while (leftColorToIndices.containsKey(color) && rightColorToIndices.containsKey(color)) {
					addPair(pairs, leftColorToIndices, color, rightColorToIndices, color);
				}
			}
		}
		for (int i = Math.max(0,
				leftColorToIndices.getOrDefault('?', Collections.emptyList()).size()
						+ rightColorToIndices.getOrDefault('?', Collections.emptyList()).size()
						- (l.length() - pairs.size())); i > 0; --i) {
			addPair(pairs, leftColorToIndices, '?', rightColorToIndices, '?');
		}
		while (leftColorToIndices.containsKey('?')) {
			addPair(pairs, leftColorToIndices, '?', rightColorToIndices,
					rightColorToIndices.keySet().iterator().next());
		}
		while (rightColorToIndices.containsKey('?')) {
			addPair(pairs, leftColorToIndices, leftColorToIndices.keySet().iterator().next(), rightColorToIndices, '?');
		}

		return String.format("%d\n%s", pairs.size(), String.join("\n", pairs));
	}

	static Map<Character, List<Integer>> buildColorToIndices(String s) {
		Map<Character, List<Integer>> colorToIndices = new HashMap<>();
		for (int i = 0; i < s.length(); ++i) {
			char color = s.charAt(i);
			if (!colorToIndices.containsKey(color)) {
				colorToIndices.put(color, new ArrayList<>());
			}

			colorToIndices.get(color).add(i);
		}

		return colorToIndices;
	}

	static void addPair(List<String> pairs, Map<Character, List<Integer>> leftColorToIndices, char leftColor,
			Map<Character, List<Integer>> rightColorToIndices, char rightColor) {
		pairs.add(String.format("%d %d", pop(leftColorToIndices, leftColor) + 1,
				pop(rightColorToIndices, rightColor) + 1));
	}

	static int pop(Map<Character, List<Integer>> colorToIndices, char color) {
		List<Integer> indices = colorToIndices.get(color);
		int index = indices.remove(indices.size() - 1);

		if (indices.isEmpty()) {
			colorToIndices.remove(color);
		}

		return index;
	}
}
