import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] names = new String[n];
		for (int i = 0; i < names.length; i++) {
			names[i] = sc.next();
		}
		System.out.println(solve(names));

		sc.close();
	}

	static String solve(String[] names) {
		Set<String> seen = new HashSet<>();
		List<String> result = new ArrayList<>();
		for (int i = names.length - 1; i >= 0; i--) {
			if (!seen.contains(names[i])) {
				result.add(names[i]);
				seen.add(names[i]);
			}
		}

		return String.join("\n", result);
	}
}
