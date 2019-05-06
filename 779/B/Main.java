import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static int solve(int n, int k) {
		String nStr = String.valueOf(n);

		int result = 0;
		for (int i = nStr.length() - 1; i >= 0; i--) {
			if (nStr.charAt(i) == '0') {
				k--;

				if (k == 0) {
					return result;
				}
			} else {
				result++;
			}
		}

		return nStr.length() - 1;
	}
}
