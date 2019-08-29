import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(long n) {
		int[] digitSums = String.valueOf(n).chars().map(ch -> ch - '0').toArray();

		for (int i = 0; i < digitSums.length - 1; i++) {
			digitSums[i]--;
			digitSums[i + 1] += 10;
		}

		for (int i = digitSums.length - 1; i >= 1; i--) {
			if (digitSums[i] == 19) {
				digitSums[i] -= 10;
				digitSums[i - 1]++;
			}
		}

		return Arrays.stream(digitSums).sum();
	}
}
