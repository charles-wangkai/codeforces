import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = sc.nextInt();
		}
		System.out.println(solve(t, a));

		sc.close();
	}

	static int solve(int[] t, int a) {
		int result = t[a - 1];
		for (int distance = 1;; distance++) {
			int cityCount = 0;
			int criminalCount = 0;

			for (int offset : new int[] { -distance, distance }) {
				int index = a - 1 + offset;

				if (index >= 0 && index < t.length) {
					cityCount++;

					if (t[index] == 1) {
						criminalCount++;
					}
				}
			}

			if (cityCount == 0) {
				break;
			}

			if (cityCount == criminalCount) {
				result += criminalCount;
			}
		}
		return result;
	}
}
