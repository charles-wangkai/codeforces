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
		boolean[] interestings = new boolean[91];

		for (int ti : t) {
			interestings[ti] = true;
		}

		int boringCount = 0;
		for (int i = 1; i < interestings.length; i++) {
			if (interestings[i]) {
				boringCount = 0;
			} else {
				boringCount++;

				if (boringCount == 15) {
					return i;
				}
			}
		}
		return interestings.length - 1;
	}
}
