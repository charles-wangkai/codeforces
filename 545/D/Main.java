import java.util.Arrays;
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
		Arrays.sort(t);

		int result = 0;
		long waitTime = 0;
		for (int serveTime : t) {
			if (waitTime <= serveTime) {
				result++;

				waitTime += serveTime;
			}
		}

		return result;
	}
}
