import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int[] MONTH_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static final String[] DAY_NAMES = { "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String name1 = sc.next();
		String name2 = sc.next();
		System.out.println(solve(name1, name2) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String name1, String name2) {
		int dayDiff = computeDayDiff(name1, name2);

		return IntStream.range(0, MONTH_DAYS.length - 1).anyMatch(i -> MONTH_DAYS[i] % 7 == dayDiff);
	}

	static int computeDayDiff(String name1, String name2) {
		return (findIndex(name2) - findIndex(name1) + 7) % 7;
	}

	static int findIndex(String name) {
		return IntStream.range(0, DAY_NAMES.length).filter(i -> DAY_NAMES[i].equals(name)).findAny().getAsInt();
	}
}
