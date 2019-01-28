import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] bills = new int[n];
		for (int i = 0; i < bills.length; i++) {
			bills[i] = sc.nextInt();
		}
		System.out.println(solve(bills) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] bills) {
		int count25 = 0;
		int count50 = 0;
		for (int bill : bills) {
			if (bill == 25) {
				count25++;
			} else if (bill == 50) {
				if (count25 >= 1) {
					count25--;
				} else {
					return false;
				}

				count50++;
			} else if (bill == 100) {
				if (count50 >= 1 && count25 >= 1) {
					count50--;
					count25--;
				} else if (count25 >= 3) {
					count25 -= 3;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
