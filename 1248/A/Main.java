import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int[] p = readArray(sc);
			int[] q = readArray(sc);

			System.out.println(solve(p, q));
		}

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

	static long solve(int[] p, int[] q) {
		int evenCountP = (int) Arrays.stream(p).filter(x -> x % 2 == 0).count();
		int oddCountP = (int) Arrays.stream(p).filter(x -> x % 2 != 0).count();
		int evenCountQ = (int) Arrays.stream(q).filter(x -> x % 2 == 0).count();
		int oddCountQ = (int) Arrays.stream(q).filter(x -> x % 2 != 0).count();

		return (long) evenCountP * evenCountQ + (long) oddCountP * oddCountQ;
	}
}
