import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(solve(a, b, c));

		sc.close();
	}

	static int solve(int a, int b, int c) {
		int cycle = Math.min(Math.min(a / 3, b / 2), c / 2);

		return cycle * 7 + IntStream.rangeClosed(1, 7)
				.map(startDay -> computeDayNum(a - cycle * 3, b - cycle * 2, c - cycle * 2, startDay)).max().getAsInt();
	}

	static int computeDayNum(int remainA, int remainB, int remainC, int startDay) {
		int result = 0;
		for (int day = startDay;; day = day % 7 + 1) {
			if (day == 1 || day == 4 || day == 7) {
				if (remainA == 0) {
					break;
				}

				remainA--;
			} else if (day == 2 || day == 6) {
				if (remainB == 0) {
					break;
				}

				remainB--;
			} else {
				if (remainC == 0) {
					break;
				}

				remainC--;
			}

			result++;
		}

		return result;
	}
}
