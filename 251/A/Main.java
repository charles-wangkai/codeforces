import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(x, d));

		sc.close();
	}

	static long solve(int[] x, int d) {
		long result = 0;
		int beginIndex = 0;
		for (int endIndex = 2; endIndex < x.length; endIndex++) {
			while (x[endIndex] - x[beginIndex] > d) {
				beginIndex++;
			}

			result += (endIndex - beginIndex) * (endIndex - beginIndex - 1L) / 2;
		}
		return result;
	}
}
