import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int y = sc.nextInt();
		System.out.println(solve(y));

		sc.close();
	}

	static int solve(int y) {
		while (true) {
			y++;

			if (String.valueOf(y).length() == String.valueOf(y).chars().distinct().count()) {
				return y;
			}
		}
	}
}
