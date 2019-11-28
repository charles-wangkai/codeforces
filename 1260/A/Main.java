import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			int c = sc.nextInt();
			int sum = sc.nextInt();

			System.out.println(solve(c, sum));
		}

		sc.close();
	}

	static int solve(int c, int sum) {
		int[] sectionNums = new int[c];
		for (int i = 0; i < sectionNums.length; i++) {
			sectionNums[i] = sum / c;

			if (i < sum % c) {
				sectionNums[i]++;
			}
		}

		return Arrays.stream(sectionNums).map(x -> x * x).sum();
	}
}
