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
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		int[] sortedA = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		int result = 0;
		int beginIndex = 0;
		for (int i = 0; i < sortedA.length; i++) {
			while (sortedA[i] - sortedA[beginIndex] > 5) {
				beginIndex++;
			}

			result = Math.max(result, i - beginIndex + 1);
		}
		return result;
	}
}
