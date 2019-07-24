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
		int peakIndex = IntStream.range(0, a.length).filter(i -> a[i] == a.length).findAny().getAsInt();

		return IntStream.rangeClosed(0, peakIndex - 1).allMatch(i -> a[i] < a[i + 1])
				&& IntStream.rangeClosed(peakIndex, a.length - 2).allMatch(i -> a[i] > a[i + 1]);
	}
}
