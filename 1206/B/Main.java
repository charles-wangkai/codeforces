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

	static long solve(int[] a) {
		long result = 0;
		int negCount = 0;
		int zeroCount = 0;
		for (int ai : a) {
			if (ai < 0) {
				result += -1 - ai;
				negCount++;
			} else if (ai > 0) {
				result += ai - 1;
			} else {
				result++;
				zeroCount++;
			}
		}

		if (zeroCount == 0 && negCount % 2 != 0) {
			result += 2;
		}

		return result;
	}
}
