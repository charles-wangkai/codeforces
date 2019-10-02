import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		String a = sc.next();
		System.out.println(solve(a, x, y));

		sc.close();
	}

	static long solve(String a, int x, int y) {
		int zeroSegmentNum = (int) IntStream.range(0, a.length())
				.filter(i -> a.charAt(i) == '0' && (i == 0 || a.charAt(i - 1) == '1')).count();

		if (zeroSegmentNum == 0) {
			return 0;
		} else {
			return y + Math.min(x, y) * (zeroSegmentNum - 1L);
		}
	}
}
