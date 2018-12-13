import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String players = sc.next();
		System.out.println(solve(players) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String players) {
		return players.contains("0000000") || players.contains("1111111");
	}
}
