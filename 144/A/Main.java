import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		int max = Arrays.stream(a).max().getAsInt();
		int min = Arrays.stream(a).min().getAsInt();

		int maxIndex = Arrays.stream(a).boxed().collect(Collectors.toList()).indexOf(max);
		int minIndex = Arrays.stream(a).boxed().collect(Collectors.toList()).lastIndexOf(min);

		return maxIndex + (a.length - 1 - minIndex) - (maxIndex > minIndex ? 1 : 0);
	}
}
