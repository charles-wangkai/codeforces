import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();
		int c = sc.nextInt();
		int[] severities = new int[n];
		for (int i = 0; i < severities.length; i++) {
			severities[i] = sc.nextInt();
		}
		System.out.println(solve(severities, t, c));

		sc.close();
	}

	static int solve(int[] severities, int t, int c) {
		int result = 0;
		int greaterCnt = 0;
		int leftIndex = 0;
		for (int rightIndex = 0; rightIndex < severities.length; rightIndex++) {
			if (severities[rightIndex] > t) {
				greaterCnt++;
			}

			if (rightIndex - leftIndex + 1 == c + 1) {
				if (severities[leftIndex] > t) {
					greaterCnt--;
				}

				leftIndex++;
			}

			if (rightIndex - leftIndex + 1 == c && greaterCnt == 0) {
				result++;
			}
		}
		return result;
	}
}
