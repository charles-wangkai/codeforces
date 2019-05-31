import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(Arrays.stream(solve(n, k)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static int[] solve(int n, int k) {
		int[] result = new int[n];
		int left = 1;
		int right = n;
		int index = 0;
		for (int i = 0; i < n - k; i++) {
			result[index] = left;
			index++;
			left++;
		}

		boolean leftOrRight = false;
		while (index < result.length) {
			if (leftOrRight) {
				result[index] = left;
				left++;
			} else {
				result[index] = right;
				right--;
			}

			index++;
			leftOrRight = !leftOrRight;
		}

		return result;
	}
}
