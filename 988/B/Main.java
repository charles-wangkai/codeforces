import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] strings = new String[n];
		for (int i = 0; i < strings.length; i++) {
			strings[i] = sc.next();
		}
		System.out.println(solve(strings));

		sc.close();
	}

	static String solve(String[] strings) {
		Arrays.sort(strings, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

		if (IntStream.range(0, strings.length - 1).allMatch(i -> strings[i + 1].contains(strings[i]))) {
			return String.format("YES\n%s", String.join("\n", strings));
		} else {
			return "NO";
		}
	}
}
