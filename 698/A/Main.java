import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		int n = a.length;

		int[] lastRestMinRests = new int[n];
		Arrays.fill(lastRestMinRests, Integer.MAX_VALUE);

		int[] lastSportMinRests = new int[n];
		Arrays.fill(lastSportMinRests, Integer.MAX_VALUE);

		int[] lastContestMinRests = new int[n];
		Arrays.fill(lastContestMinRests, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				lastRestMinRests[i] = 1;
			} else {
				int prevMin = Math.min(Math.min(lastRestMinRests[i - 1], lastSportMinRests[i - 1]),
						lastContestMinRests[i - 1]);
				if (prevMin != Integer.MAX_VALUE) {
					lastRestMinRests[i] = prevMin + 1;
				}
			}

			if (a[i] == 2 || a[i] == 3) {
				if (i == 0) {
					lastSportMinRests[i] = 0;
				} else {
					lastSportMinRests[i] = Math.min(lastRestMinRests[i - 1], lastContestMinRests[i - 1]);
				}
			}

			if (a[i] == 1 || a[i] == 3) {
				if (i == 0) {
					lastContestMinRests[i] = 0;
				} else {
					lastContestMinRests[i] = Math.min(lastRestMinRests[i - 1], lastSportMinRests[i - 1]);
				}
			}
		}

		return Math.min(Math.min(lastRestMinRests[n - 1], lastSportMinRests[n - 1]), lastContestMinRests[n - 1]);
	}
}
