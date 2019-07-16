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

	static String solve(int[] a) {
		int n = a.length;

		int[] sortedA = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();
		if (sortedA[n - 3] + sortedA[n - 2] <= sortedA[n - 1]) {
			return "NO";
		}

		int[] result = sortedA;
		int temp = result[n - 2];
		result[n - 2] = result[n - 1];
		result[n - 1] = temp;

		return String.format("YES\n%s",
				Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}
