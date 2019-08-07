import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] s = new String[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.next();
		}
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String[] s) {
		return (int) Arrays.stream(s).map(Main::buildLetterSet).distinct().count();
	}

	static Set<Integer> buildLetterSet(String word) {
		return word.chars().boxed().collect(Collectors.toSet());
	}
}
