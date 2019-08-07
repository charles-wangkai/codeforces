import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String home = sc.next();
		String[] flights = new String[n];
		for (int i = 0; i < flights.length; i++) {
			flights[i] = sc.next();
		}
		System.out.println(solve(home, flights));

		sc.close();
	}

	static String solve(String home, String[] flights) {
		return (flights.length % 2 == 0) ? "home" : "contest";
	}
}
