import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] b = readArray(sc, m);
		System.out.println(solve(a, b));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int[] a, int[] b) {
		int evenCountA = countEven(a);
		int evenCountB = countEven(b);

		return Math.min(evenCountA, b.length - evenCountB) + Math.min(a.length - evenCountA, evenCountB);
	}

	static int countEven(int[] p) {
		return (int) Arrays.stream(p).filter(x -> x % 2 == 0).count();
	}
}
