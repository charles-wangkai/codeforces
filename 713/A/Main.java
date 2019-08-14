import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		char[] types = new char[t];
		long[] arguments = new long[t];
		for (int i = 0; i < t; i++) {
			types[i] = sc.next().charAt(0);
			arguments[i] = sc.nextLong();
		}
		System.out.println(solve(types, arguments));

		sc.close();
	}

	static String solve(char[] types, long[] arguments) {
		List<Integer> result = new ArrayList<>();

		Map<Long, Integer> patternToCount = new HashMap<>();
		for (int i = 0; i < types.length; i++) {
			if (types[i] == '?') {
				result.add(patternToCount.getOrDefault(arguments[i], 0));
			} else {
				long pattern = buildPattern(arguments[i]);

				if (types[i] == '+') {
					patternToCount.put(pattern, patternToCount.getOrDefault(pattern, 0) + 1);
				} else {
					patternToCount.put(pattern, patternToCount.get(pattern) - 1);
				}
			}
		}

		return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}

	static long buildPattern(long n) {
		long result = 0;
		long placeValue = 1;
		while (n != 0) {
			result += n % 2 * placeValue;

			n /= 10;
			placeValue *= 10;
		}

		return result;
	}
}
