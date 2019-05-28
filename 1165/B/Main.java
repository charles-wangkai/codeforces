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

		int index = 0;
		for (int day = 1;; day++) {
			while (index < sortedA.length && sortedA[index] < day) {
				index++;
			}

			if (index == sortedA.length) {
				return day - 1;
			}

			index++;
		}
	}
}
