import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] a = readArray(sc);
		int[] b = readArray(sc);
		System.out.println(solve(a, b));

		sc.close();
	}

	static int[] readArray(Scanner sc) {
		int size = sc.nextInt();
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static int solve(int[] a, int[] b) {
		int maxRatio = -1;
		int countForMaxRatio = -1;
		for (int ai : a) {
			for (int bj : b) {
				if (bj % ai == 0) {
					int ratio = bj / ai;

					if (ratio > maxRatio) {
						maxRatio = ratio;
						countForMaxRatio = 1;
					} else if (ratio == maxRatio) {
						countForMaxRatio++;
					}
				}
			}
		}

		return countForMaxRatio;
	}
}
