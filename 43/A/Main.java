import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
		Map<String, Integer> nameToCount = new HashMap<>();
		for (String name : names) {
			nameToCount.put(name, nameToCount.getOrDefault(name, 0) + 1);
		}

		int maxCount = nameToCount.values().stream().mapToInt(x -> x).max().getAsInt();
		return nameToCount.keySet().stream().filter(name -> nameToCount.get(name) == maxCount).findAny().get();
	}
}
