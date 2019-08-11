import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String genome1 = sc.next();
		String genome2 = sc.next();
		System.out.println(solve(genome1, genome2) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String genome1, String genome2) {
		if (genome1.length() != genome2.length()) {
			return false;
		}

		int[] diffIndices = IntStream.range(0, genome1.length()).filter(i -> genome1.charAt(i) != genome2.charAt(i))
				.toArray();

		return diffIndices.length == 2 && genome1.charAt(diffIndices[0]) == genome2.charAt(diffIndices[1])
				&& genome1.charAt(diffIndices[1]) == genome2.charAt(diffIndices[0]);
	}
}
