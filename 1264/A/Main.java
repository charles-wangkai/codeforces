import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int[] p = new int[n];
			for (int i = 0; i < p.length; i++) {
				p[i] = sc.nextInt();
			}

			System.out.println(solve(p));
		}

		sc.close();
	}

	static String solve(int[] p) {
		int bronzeEndIndex = p.length / 2 - 1;
		while (bronzeEndIndex >= 0 && bronzeEndIndex + 1 < p.length && p[bronzeEndIndex] == p[bronzeEndIndex + 1]) {
			bronzeEndIndex--;
		}

		if (bronzeEndIndex < 0) {
			return "0 0 0";
		}

		int goldEndIndex = 0;
		while (p[goldEndIndex] == p[goldEndIndex + 1]) {
			goldEndIndex++;
		}

		if (goldEndIndex == bronzeEndIndex) {
			return "0 0 0";
		}

		int silverEndIndex = goldEndIndex + 1;
		while (p[silverEndIndex] == p[silverEndIndex + 1] || silverEndIndex - goldEndIndex <= goldEndIndex + 1) {
			if (silverEndIndex == bronzeEndIndex) {
				return "0 0 0";
			}

			silverEndIndex++;
		}

		if (bronzeEndIndex - silverEndIndex <= goldEndIndex + 1) {
			return "0 0 0";
		}

		return String.format("%d %d %d", goldEndIndex + 1, silverEndIndex - goldEndIndex,
				bronzeEndIndex - silverEndIndex);
	}
}
