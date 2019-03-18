import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int k = sc.nextInt();
		String cells = sc.next();
		System.out.println(solve(cells, k) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String cells, int k) {
		int indexG = find(cells, 'G');
		int indexT = find(cells, 'T');

		int distance = indexT - indexG;

		return distance % k == 0 && IntStream.range(1, Math.abs(distance / k))
				.allMatch(i -> cells.charAt(indexG + (int) Math.signum(distance) * k * i) == '.');
	}

	static int find(String cells, char target) {
		for (int i = 0;; i++) {
			if (cells.charAt(i) == target) {
				return i;
			}
		}
	}
}
