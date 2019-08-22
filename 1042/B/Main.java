import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] c = new int[n];
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			c[i] = sc.nextInt();
			s[i] = sc.next();
		}
		System.out.println(solve(c, s));

		sc.close();
	}

	static int solve(int[] c, String[] s) {
		Map<String, Integer> groupToMinPrice = new HashMap<>();
		for (int i = 0; i < c.length; i++) {
			String group = buildGroup(s[i]);

			groupToMinPrice.put(group, Math.min(groupToMinPrice.getOrDefault(group, Integer.MAX_VALUE), c[i]));
		}

		int result = Integer.MAX_VALUE;
		for (String[] groups : new String[][] { { "ABC" }, { "AB", "AC" }, { "AB", "BC" }, { "AC", "BC" },
				{ "AB", "C" }, { "AC", "B" }, { "A", "BC" }, { "A", "B", "C" } }) {
			if (Arrays.stream(groups).allMatch(groupToMinPrice::containsKey)) {
				result = Math.min(result, Arrays.stream(groups).mapToInt(groupToMinPrice::get).sum());
			}
		}

		return (result == Integer.MAX_VALUE) ? -1 : result;
	}

	static String buildGroup(String str) {
		return str.chars().sorted().mapToObj(ch -> (char) ch)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
