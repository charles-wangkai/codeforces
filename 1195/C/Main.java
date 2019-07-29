import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] h1 = readArray(sc, n);
		int[] h2 = readArray(sc, n);
		System.out.println(solve(h1, h2));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static long solve(int[] h1, int[] h2) {
		long max1 = 0;
		long max2 = 0;
		for (int i = 0; i < h1.length; i++) {
			long nextMax1 = Math.max(max1, max2 + h1[i]);
			long nextMax2 = Math.max(max2, max1 + h2[i]);

			max1 = nextMax1;
			max2 = nextMax2;
		}

		return Math.max(max1, max2);
	}
}
