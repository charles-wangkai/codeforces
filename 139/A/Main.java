import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] pages = new int[7];
		for (int i = 0; i < pages.length; i++) {
			pages[i] = sc.nextInt();
		}
		System.out.println(solve(n, pages));

		sc.close();
	}

	static int solve(int n, int[] pages) {
		int day = 0;
		while (true) {
			n -= pages[day];

			if (n <= 0) {
				return day + 1;
			}

			day = (day + 1) % pages.length;
		}
	}
}
