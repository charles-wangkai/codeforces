import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(String.join(" ", Arrays.stream(solve(a)).mapToObj(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static int[] solve(int[] a) {
		for (int i = 0, j = a.length - 1; i < j; i += 2, j -= 2) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		return a;
	}
}
