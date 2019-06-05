import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[2 * n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		if (Arrays.stream(a).distinct().count() == 1) {
			return "-1";
		} else {
			return Arrays.stream(a).boxed().sorted().map(String::valueOf).collect(Collectors.joining(" "));
		}
	}
}
