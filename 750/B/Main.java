import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] t = new int[n];
		String[] dir = new String[n];
		for (int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
			dir[i] = sc.next();
		}
		System.out.println(solve(t, dir) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] t, String[] dir) {
		int position = 0;
		for (int i = 0; i < t.length; i++) {
			if (dir[i].equals("North")) {
				position -= t[i];
			} else if (dir[i].equals("South")) {
				position += t[i];
			} else if (position == 0 || position == 20000) {
				return false;
			}

			if (position < 0 || position > 20000) {
				return false;
			}
		}
		return position == 0;
	}
}
