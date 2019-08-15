import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String colors = sc.next();
		System.out.println(solve(colors));

		sc.close();
	}

	static int solve(String colors) {
		return Math.min(computeTurnNum(colors, 'b'), computeTurnNum(colors, 'r'));
	}

	static int computeTurnNum(String colors, char startColor) {
		int evenDiffCount = 0;
		int oddDiffCount = 0;
		for (int i = 0; i < colors.length(); i++) {
			char color = colors.charAt(i);

			if (i % 2 == 0) {
				if (color != startColor) {
					evenDiffCount++;
				}
			} else {
				if (color == startColor) {
					oddDiffCount++;
				}
			}
		}

		return Math.max(evenDiffCount, oddDiffCount);
	}
}
