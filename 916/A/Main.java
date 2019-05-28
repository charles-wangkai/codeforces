import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		System.out.println(solve(x, hour, minute));

		sc.close();
	}

	static int solve(int x, int hour, int minute) {
		for (int i = 0;; i++) {
			if (String.format("%d%d", hour, minute).indexOf('7') >= 0) {
				return i;
			}

			minute -= x;
			if (minute < 0) {
				minute += 60;
				hour = (hour + 23) % 24;
			}
		}
	}
}
