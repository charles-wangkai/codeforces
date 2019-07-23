import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();
		System.out.println(solve(s, t));

		sc.close();
	}

	static String solve(String s, String t) {
		int bedTime = (convertToTotalMinute(s) - convertToTotalMinute(t) + 24 * 60) % (24 * 60);

		return String.format("%02d:%02d", bedTime / 60, bedTime % 60);
	}

	static int convertToTotalMinute(String time) {
		int hour = Integer.parseInt(time.substring(0, 2));
		int minute = Integer.parseInt(time.substring(3));

		return hour * 60 + minute;
	}
}
