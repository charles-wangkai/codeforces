import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String[] groups = new String[10];
		for (int i = 0; i < groups.length; i++) {
			groups[i] = sc.next();
		}
		System.out.println(solve(s, groups));

		sc.close();
	}

	static String solve(String s, String[] groups) {
		Map<String, Integer> groupToDigit = IntStream.range(0, groups.length).boxed()
				.collect(Collectors.toMap(i -> groups[i], Function.identity()));

		return IntStream.range(0, 8).mapToObj(i -> String.valueOf(groupToDigit.get(s.substring(i * 10, i * 10 + 10))))
				.collect(Collectors.joining());
	}
}
