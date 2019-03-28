import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		int h = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(w, h, k));

		sc.close();
	}

	static int solve(int w, int h, int k) {
		int result = 0;
		for (int i = 0; i < k; i++) {
			result += 2 * (w + h - 2);

			w -= 4;
			h -= 4;
		}
		return result;
	}
}
