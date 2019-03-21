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
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		int[] turnIndices = IntStream.range(0, a.length - 1).filter(i -> a[i] > a[i + 1]).toArray();

		if (turnIndices.length == 0) {
			return 0;
		} else if (turnIndices.length == 1 && a[a.length - 1] <= a[0]) {
			return a.length - turnIndices[0] - 1;
		} else {
			return -1;
		}
	}
}
