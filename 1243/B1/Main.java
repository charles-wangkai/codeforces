import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		for (int tc = 0; tc < k; tc++) {
			sc.nextInt();
			String s = sc.next();
			String t = sc.next();

			System.out.println(solve(s, t) ? "Yes" : "No");
		}

		sc.close();
	}

	static boolean solve(String s, String t) {
		int[] diffIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) != t.charAt(i)).toArray();

		return diffIndices.length == 2 && s.charAt(diffIndices[0]) == s.charAt(diffIndices[1])
				&& t.charAt(diffIndices[0]) == t.charAt(diffIndices[1]);
	}
}
