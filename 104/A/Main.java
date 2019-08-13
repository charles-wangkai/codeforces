import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		int target = n - 10;

		if (target >= 1 && target <= 9) {
			return 4;
		} else if (target == 10) {
			return 15;
		} else if (target == 11) {
			return 4;
		} else {
			return 0;
		}
	}
}
