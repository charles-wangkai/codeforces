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

	static String solve(String s, int k) {
		int[] counts = new int[26];
		for (char letter : s.toCharArray()) {
			counts[letter - 'a']++;
		}

		int[] skips = new int[counts.length];
		for (int i = 0; i < skips.length; i++) {
			skips[i] = Math.min(counts[i], k);
			k -= skips[i];
		}

		StringBuilder result = new StringBuilder();
		for (char letter : s.toCharArray()) {
			if (skips[letter - 'a'] == 0) {
				result.append(letter);
			} else {
				skips[letter - 'a']--;
			}
		}
		return result.toString();
	}
}
