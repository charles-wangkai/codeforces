import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.print(solve(n, a, b, c));

		sc.close();
	}

	static int solve(int n, int a, int b, int c) {
		int[] maxPieceNum = new int[n + 1];
		for (int i = 0; i < maxPieceNum.length; i++) {
			if (i == 0 || maxPieceNum[i] != 0) {
				for (int j : new int[] { a, b, c }) {
					if (i + j < maxPieceNum.length) {
						maxPieceNum[i + j] = Math.max(maxPieceNum[i + j], maxPieceNum[i] + 1);
					}
				}
			}
		}
		return maxPieceNum[n];
	}
}
