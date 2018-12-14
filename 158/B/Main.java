import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(int[] s) {
		int[] counts = new int[5];
		for (int si : s) {
			counts[si]++;
		}

		int texiNum = 0;
		while (Arrays.stream(counts).anyMatch(x -> x != 0)) {
			int seat = 4;
			for (int i = counts.length - 1; i >= 1; i--) {
				while (i <= seat && counts[i] != 0) {
					counts[i]--;
					seat -= i;
				}
			}

			texiNum++;
		}
		return texiNum;
	}
}
