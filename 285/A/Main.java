import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static String solve(int n, int k) {
		int[] permutation = IntStream.rangeClosed(1, n).toArray();
		reverse(permutation, 0, k);

		return Arrays.stream(permutation).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}

	static void reverse(int[] a, int beginIndex, int endIndex) {
		for (int i = beginIndex, j = endIndex; i < j; i++, j--) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
}
