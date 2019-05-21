import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String a = sc.next();
		String b = sc.next();
		System.out.println(solve(a, b));

		sc.close();
	}

	static long solve(String a, String b) {
		Map<String, Integer> groupToCount = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			String group = String.format("%c%c", a.charAt(i), b.charAt(i));

			groupToCount.put(group, groupToCount.getOrDefault(group, 0) + 1);
		}

		return (long) groupToCount.getOrDefault("00", 0) * groupToCount.getOrDefault("10", 0)
				+ (long) groupToCount.getOrDefault("00", 0) * groupToCount.getOrDefault("11", 0)
				+ (long) groupToCount.getOrDefault("01", 0) * groupToCount.getOrDefault("10", 0);
	}
}
