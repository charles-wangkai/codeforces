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
		System.out.println(solve(a) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] a) {
		int maxValue = Arrays.stream(a).max().getAsInt();

		int leftIndex = 0;
		while (a[leftIndex] != maxValue) {
			leftIndex++;
		}

		int rightIndex = a.length - 1;
		while (a[rightIndex] != maxValue) {
			rightIndex--;
		}

		return IntStream.range(0, leftIndex - 1).allMatch(i -> a[i] < a[i + 1])
				&& IntStream.rangeClosed(leftIndex, rightIndex).allMatch(i -> a[i] == maxValue)
				&& IntStream.range(rightIndex + 1, a.length - 1).allMatch(i -> a[i] > a[i + 1]);
	}
}
