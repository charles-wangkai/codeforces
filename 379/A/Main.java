import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(a, b));

		sc.close();
	}

	static int solve(int a, int b) {
		int hour = 0;
		int oldNum = 0;
		while (a > 0) {
			hour += a;

			oldNum += a;
			a = oldNum / b;
			oldNum %= b;
		}
		return hour;
	}
}
