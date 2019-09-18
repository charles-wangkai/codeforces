import java.util.Arrays;
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
		System.out.print(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		a = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		int minDistance = computeMinDistance(a);
		int pairNumWithMinDistance = computePairNumWithMinDistance(a, minDistance);

		return String.format("%d %d", minDistance, pairNumWithMinDistance);
	}

	static int computeMinDistance(int[] a) {
		return IntStream.range(0, a.length - 1).map(i -> a[i + 1] - a[i]).min().getAsInt();
	}

	static int computePairNumWithMinDistance(int[] a, int minDistance) {
		return (int) IntStream.range(0, a.length - 1).filter(i -> a[i + 1] - a[i] == minDistance).count();
	}
}
