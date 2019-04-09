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
		int[] sortedWeights = s.chars().map(ch -> ch - 'a' + 1).sorted().toArray();

		int result = 0;
		int prev = -1;
		int index = 0;
		for (int i = 0; i < k; i++) {
			while (index < sortedWeights.length && sortedWeights[index] - prev <= 1) {
				index++;
			}

			if (index == sortedWeights.length) {
				return -1;
			}

			result += sortedWeights[index];
			prev = sortedWeights[index];
			index++;
		}
		return result;
	}
}
