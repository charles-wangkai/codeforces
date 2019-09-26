import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(x));

		sc.close();
	}

	static int solve(int[] a) {
		return Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray()[(a.length - 1) / 2];
	}
}
