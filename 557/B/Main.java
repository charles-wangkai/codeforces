import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int w = sc.nextInt();
		int[] a = new int[n * 2];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, w));

		sc.close();
	}

	static double solve(int[] a, int w) {
		int n = a.length / 2;
		a = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		return Math.min(w, (Math.min(a[0], a[n] / 2.0) + Math.min(a[n], a[0] * 2)) * n);
	}
}
