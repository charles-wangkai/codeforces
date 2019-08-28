import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static long solve(String s) {
		int[] leftWCounts = new int[s.length()];
		int leftWCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i != 0 && s.charAt(i) == 'v' && s.charAt(i - 1) == 'v') {
				leftWCount++;
			}

			leftWCounts[i] = leftWCount;
		}

		int[] rightWCounts = new int[s.length()];
		int rightWCount = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (i != s.length() - 1 && s.charAt(i) == 'v' && s.charAt(i + 1) == 'v') {
				rightWCount++;
			}

			rightWCounts[i] = rightWCount;
		}

		return IntStream.range(0, s.length()).filter(i -> s.charAt(i) == 'o')
				.mapToLong(i -> (long) leftWCounts[i] * rightWCounts[i]).sum();
	}
}
