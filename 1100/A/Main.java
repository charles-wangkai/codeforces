import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] types = new int[n];
		for (int i = 0; i < types.length; i++) {
			types[i] = sc.nextInt();
		}
		System.out.println(solve(types, k));

		sc.close();
	}

	static int solve(int[] types, int k) {
		int countPos = (int) Arrays.stream(types).filter(type -> type == 1).count();
		int countNeg = types.length - countPos;

		int result = -1;
		for (int i = 0; i < k; i++) {
			int e = countPos;
			int s = countNeg;
			for (int j = i; j < types.length; j += k) {
				if (types[j] == 1) {
					e--;
				} else {
					s--;
				}
			}

			result = Math.max(result, Math.abs(e - s));
		}
		return result;
	}
}
