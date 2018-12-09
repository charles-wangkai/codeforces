import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		System.out.println(solve(w) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int w) {
		return w >= 4 && w % 2 == 0;
	}
}
