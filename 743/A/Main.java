import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		String airports = sc.next();
		System.out.println(solve(airports, a, b));

		sc.close();
	}

	static int solve(String airports, int a, int b) {
		return (airports.charAt(a - 1) == airports.charAt(b - 1)) ? 0 : 1;
	}
}
