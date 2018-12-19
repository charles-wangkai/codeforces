import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] levelsX = readArray(sc);
		int[] levelsY = readArray(sc);
		System.out.println(solve(n, levelsX, levelsY) ? "I become the guy." : "Oh, my keyboard!");

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

	static boolean solve(int n, int[] levelsX, int[] levelsY) {
		return IntStream.concat(Arrays.stream(levelsX), Arrays.stream(levelsY)).distinct().count() == n;
	}
}
