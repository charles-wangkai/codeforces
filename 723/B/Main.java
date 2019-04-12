import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		String outside = s;
		String inside = "";
		while (true) {
			int leftIndex = outside.indexOf('(');
			if (leftIndex < 0) {
				break;
			}

			int rightIndex = outside.indexOf(')');
			inside += "_" + outside.substring(leftIndex + 1, rightIndex);
			outside = outside.substring(0, leftIndex) + "_" + outside.substring(rightIndex + 1);
		}

		return String.format("%d %d", extractWords(outside).stream().mapToInt(String::length).max().orElse(0),
				extractWords(inside).size());
	}

	static List<String> extractWords(String part) {
		return Arrays.stream(part.split("_")).filter(word -> !word.isEmpty()).collect(Collectors.toList());
	}
}
