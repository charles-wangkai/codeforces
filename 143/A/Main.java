import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c1 = sc.nextInt();
		int c2 = sc.nextInt();
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		System.out.println(solve(r1, r2, c1, c2, d1, d2));

		sc.close();
	}

	static String solve(int r1, int r2, int c1, int c2, int d1, int d2) {
		for (int x1 = 1; x1 <= 9; x1++) {
			for (int x2 = 1; x2 <= 9; x2++) {
				for (int x3 = 1; x3 <= 9; x3++) {
					for (int x4 = 1; x4 <= 9; x4++) {
						if (IntStream.of(x1, x2, x3, x4).distinct().count() == 4 && x1 + x2 == r1 && x3 + x4 == r2
								&& x1 + x3 == c1 && x2 + x4 == c2 && x1 + x4 == d1 && x2 + x3 == d2) {
							return String.format("%d %d\n%d %d", x1, x2, x3, x4);
						}
					}
				}
			}
		}

		return "-1";
	}
}
