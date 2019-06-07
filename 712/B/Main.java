import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		if (s.length() % 2 != 0) {
			return -1;
		}

		int x = 0;
		int y = 0;
		for (char direction : s.toCharArray()) {
			if (direction == 'L') {
				x--;
			} else if (direction == 'R') {
				x++;
			} else if (direction == 'U') {
				y++;
			} else if (direction == 'D') {
				y--;
			}
		}

		return (Math.abs(x) + Math.abs(y)) / 2;
	}
}
