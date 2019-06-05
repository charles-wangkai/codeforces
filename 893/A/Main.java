import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] a) {
		int spectator = 3;
		for (int ai : a) {
			if (ai == spectator) {
				return false;
			}

			spectator = findLoser(ai, spectator);
		}

		return true;
	}

	static int findLoser(int winner, int spectator) {
		return IntStream.rangeClosed(1, 3).filter(x -> x != winner && x != spectator).findFirst().getAsInt();
	}
}
