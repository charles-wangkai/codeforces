import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int hour = Integer.parseInt(s.substring(0, 2));
		int minute = Integer.parseInt(s.substring(3));

		for (int i = 0;; i++) {
			if (reverse(hour) == minute) {
				return i;
			}

			minute++;
			if (minute == 60) {
				minute = 0;
				hour = (hour + 1) % 24;
			}
		}
	}

	static int reverse(int x) {
		return x % 10 * 10 + x / 10;
	}
}
