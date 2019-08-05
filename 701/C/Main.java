import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int typeNum = (int) s.chars().distinct().count();

		int result = Integer.MAX_VALUE;
		Map<Character, Integer> typeToCount = new HashMap<>();
		int endIndex = -1;
		for (int beginIndex = 0;; beginIndex++) {
			while (typeToCount.size() != typeNum) {
				if (endIndex + 1 == s.length()) {
					return result;
				}

				endIndex++;
				increase(typeToCount, s.charAt(endIndex));
			}

			result = Math.min(result, endIndex - beginIndex + 1);
			decrease(typeToCount, s.charAt(beginIndex));
		}
	}

	static void increase(Map<Character, Integer> typeToCount, char type) {
		typeToCount.put(type, typeToCount.getOrDefault(type, 0) + 1);
	}

	static void decrease(Map<Character, Integer> typeToCount, char type) {
		typeToCount.put(type, typeToCount.get(type) - 1);
		typeToCount.remove(type, 0);
	}
}
