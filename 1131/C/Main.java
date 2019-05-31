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
		System.out.println(Arrays.stream(solve(a)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static int[] solve(int[] a) {
		a = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		int[] result = new int[a.length];
		int leftIndex = 0;
		int rightIndex = result.length - 1;
		boolean leftOrRight = true;
		for (int ai : a) {
			if (leftOrRight) {
				result[leftIndex] = ai;
				leftIndex++;
			} else {
				result[rightIndex] = ai;
				rightIndex--;
			}

			leftOrRight = !leftOrRight;
		}
		return result;
	}
}
