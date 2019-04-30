import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int result = 0;
		int[] keyNums = new int[26];
		for (int i = 0; i < s.length(); i += 2) {
			keyNums[s.charAt(i) - 'a']++;

			if (keyNums[s.charAt(i + 1) - 'A'] == 0) {
				result++;
			} else {
				keyNums[s.charAt(i + 1) - 'A']--;
			}
		}
		return result;
	}
}
