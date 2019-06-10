import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = sc.nextInt();
		}
		System.out.println(solve(t));

		sc.close();
	}

	static int solve(int[] t) {
		int result = 0;
		int prevCount = 0;
		int count = 1;
		for (int i = 1; i < t.length; i++) {
			if (t[i] == t[i - 1]) {
				count++;
			} else {
				prevCount = count;
				count = 1;
			}

			result = Math.max(result, Math.min(prevCount, count) * 2);
		}
		return result;
	}
}
