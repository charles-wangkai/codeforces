import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		System.out.println(solve(a1, a2));

		sc.close();
	}

	static int solve(int a1, int a2) {
		int minute = 0;
		while (!(a1 == 0 || a2 == 0 || (a1 < 2 && a2 < 2))) {
			if (a1 <= a2) {
				a1++;
				a2 -= 2;
			} else {
				a1 -= 2;
				a2++;
			}

			minute++;
		}
		return minute;
	}
}
