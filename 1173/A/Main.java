import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		System.out.println(solve(x, y, z));

		sc.close();
	}

	static char solve(int x, int y, int z) {
		char result1 = check(x + z, y);
		char result2 = check(x, y + z);

		return (result1 == result2) ? result1 : '?';
	}

	static char check(int upvote, int downvote) {
		if (upvote > downvote) {
			return '+';
		} else if (upvote < downvote) {
			return '-';
		} else {
			return '0';
		}
	}
}
