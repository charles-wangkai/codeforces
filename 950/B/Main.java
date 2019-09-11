import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] x = readArray(sc, n);
		int[] y = readArray(sc, m);
		System.out.println(solve(x, y));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static int solve(int[] x, int[] y) {
		int result = 0;
		int lengthX = 0;
		int lengthY = 0;
		int sumX = 0;
		int sumY = 0;
		while (lengthX != x.length || lengthY != y.length) {
			if (sumX <= sumY) {
				sumX += x[lengthX];
				lengthX++;
			} else {
				sumY += y[lengthY];
				lengthY++;
			}

			if (sumX == sumY) {
				result++;
			}
		}

		return result;
	}
}
