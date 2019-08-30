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
		if (Arrays.stream(a).allMatch(x -> x == 0)) {
			return "NO";
		}
		if (Arrays.stream(a).sum() != 0) {
			return String.format("YES\n1\n1 %d", a.length);
		}

		int firstNonZeroIndex = IntStream.range(0, a.length).filter(i -> a[i] != 0).findFirst().getAsInt();

		return String.format("YES\n2\n1 %d\n%d %d", firstNonZeroIndex + 1, firstNonZeroIndex + 2, a.length);
	}
}
