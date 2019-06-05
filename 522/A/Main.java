import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] name1s = new String[n];
		String[] name2s = new String[n];
		for (int i = 0; i < n; i++) {
			name1s[i] = sc.next().toLowerCase();
			sc.next();
			name2s[i] = sc.next().toLowerCase();
		}
		System.out.println(solve(name1s, name2s));

		sc.close();
	}

	static int solve(String[] name1s, String[] name2s) {
		Map<String, Integer> nameToLength = new HashMap<>();
		nameToLength.put("polycarp", 1);

		for (int i = 0; i < name1s.length; i++) {
			nameToLength.put(name1s[i], nameToLength.get(name2s[i]) + 1);
		}

		return nameToLength.values().stream().mapToInt(x -> x).max().getAsInt();
	}
}
