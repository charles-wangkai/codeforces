import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		String n = sc.next();
		System.out.println(solve(k, n));

		sc.close();
	}

	static int solve(int k, String n) {
		int[] sortedDigits = n.chars().map(ch -> ch - '0').sorted().toArray();
		int digitSum = Arrays.stream(sortedDigits).sum();

		for (int i = 0;; i++) {
			if (digitSum >= k) {
				return i;
			}

			digitSum += 9 - sortedDigits[i];
		}
	}
}
