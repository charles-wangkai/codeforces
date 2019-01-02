import java.util.Arrays;
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
		Arrays.sort(a);
		Arrays.sort(b);

		int pairNum = 0;
		int indexA = 0;
		int indexB = 0;
		while (indexA < a.length && indexB < b.length) {
			if (Math.abs(a[indexA] - b[indexB]) <= 1) {
				pairNum++;

				indexA++;
				indexB++;
			} else if (a[indexA] < b[indexB]) {
				indexA++;
			} else {
				indexB++;
			}
		}
		return pairNum;
	}
}
