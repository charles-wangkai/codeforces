import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String S = sc.next();
		System.out.println(solve(S));

		sc.close();
	}

	static int solve(String S) {
		int result = 0;
		int prev = 0;
		int curr = 0;
		int x = 0;
		int y = 0;
		for (char move : S.toCharArray()) {
			if (move == 'U') {
				y++;
			} else {
				x++;
			}

			int next = x - y;

			if ((long) next * prev < 0) {
				result++;
			}

			prev = curr;
			curr = next;
		}
		return result;
	}
}
