import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int k = sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s, k));

		sc.close();
	}

	static int solve(String s, int k) {
		int[] counts = new int[k];
		for (char letter : s.toCharArray()) {
			counts[letter - 'A']++;
		}

		return Arrays.stream(counts).min().getAsInt() * k;
	}
}
