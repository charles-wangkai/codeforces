import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		String t = sc.next();
		System.out.println(solve(s, t));

		sc.close();
	}

	static String solve(String s, String t) {
		List<Integer> abIndices = new ArrayList<>();
		List<Integer> baIndices = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				if (s.charAt(i) == 'a') {
					abIndices.add(i);
				} else {
					baIndices.add(i);
				}
			}
		}

		if ((abIndices.size() + baIndices.size()) % 2 != 0) {
			return "-1";
		}

		List<String> operations = new ArrayList<>();
		int index1 = 0;
		int index2 = 0;
		if (abIndices.size() % 2 != 0) {
			addOperation(operations, abIndices.get(0), abIndices.get(0));
			addOperation(operations, abIndices.get(0), baIndices.get(0));

			index1++;
			index2++;
		}

		for (; index1 != abIndices.size(); index1 += 2) {
			addOperation(operations, abIndices.get(index1), abIndices.get(index1 + 1));
		}

		for (; index2 != baIndices.size(); index2 += 2) {
			addOperation(operations, baIndices.get(index2), baIndices.get(index2 + 1));
		}

		return String.format("%d\n%s", operations.size(), String.join("\n", operations));
	}

	static void addOperation(List<String> operations, int sIndex, int tIndex) {
		operations.add(String.format("%d %d", sIndex + 1, tIndex + 1));
	}
}
