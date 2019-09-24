import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		String seats = sc.next();
		System.out.println(solve(seats, a, b));

		sc.close();
	}

	static int solve(String seats, int a, int b) {
		int result = 0;
		int count = 0;
		for (int i = 0; i <= seats.length(); i++) {
			if (i != seats.length() && seats.charAt(i) == '.') {
				count++;
			} else {
				int pairCount = Math.min(Math.min(a, b), count / 2);

				result += pairCount * 2;
				a -= pairCount;
				b -= pairCount;

				int remain = count - pairCount * 2;
				while (remain >= 1 && Math.max(a, b) != 0) {
					if (a <= b) {
						b--;
					} else {
						a--;
					}

					result++;
					remain -= 2;
				}

				count = 0;
			}
		}

		return result;
	}
}
