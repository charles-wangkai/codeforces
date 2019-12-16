import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			String s = sc.next();

			System.out.println(solve(s));
		}

		sc.close();
	}

	static String solve(String s) {
		Map<Character, Integer> instructionToCount = new HashMap<>();
		for (char instruction : s.toCharArray()) {
			instructionToCount.put(instruction, instructionToCount.getOrDefault(instruction, 0) + 1);
		}

		int lrCount = Math.min(instructionToCount.getOrDefault('L', 0), instructionToCount.getOrDefault('R', 0));
		int udCount = Math.min(instructionToCount.getOrDefault('U', 0), instructionToCount.getOrDefault('D', 0));

		String remaining;
		if (lrCount == 0 && udCount == 0) {
			remaining = "";
		} else if (lrCount == 0) {
			remaining = "UD";
		} else if (udCount == 0) {
			remaining = "LR";
		} else {
			remaining = String.format("%s%s%s%s", repeat('L', lrCount), repeat('U', udCount), repeat('R', lrCount),
					repeat('D', udCount));
		}

		return String.format("%d\n%s", remaining.length(), remaining);
	}

	static String repeat(char instruction, int count) {
		return IntStream.range(0, count).mapToObj(i -> instruction)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
