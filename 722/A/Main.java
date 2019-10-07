import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int format = sc.nextInt();
		String time = sc.next();
		System.out.println(solve(format, time));

		sc.close();
	}

	static String solve(int format, String time) {
		int minHour;
		int maxHour;
		if (format == 12) {
			minHour = 1;
			maxHour = 12;
		} else {
			minHour = 0;
			maxHour = 23;
		}

		int minDiffNum = Integer.MAX_VALUE;
		String result = null;
		for (int hour = minHour; hour <= maxHour; hour++) {
			for (int minute = 0; minute <= 59; minute++) {
				String t = String.format("%02d:%02d", hour, minute);
				int diffNum = (int) IntStream.range(0, time.length()).filter(i -> time.charAt(i) != t.charAt(i))
						.count();
				if (diffNum < minDiffNum) {
					minDiffNum = diffNum;
					result = t;
				}
			}
		}

		return result;
	}
}
