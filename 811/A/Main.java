import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(a, b));

		sc.close();
	}

	static String solve(int a, int b) {
		boolean turnA = true;
		int amount = 1;
		while (true) {
			if (turnA) {
				if (a < amount) {
					return "Vladik";
				}

				a -= amount;
			} else {
				if (b < amount) {
					return "Valera";
				}

				b -= amount;
			}

			amount++;
			turnA = !turnA;
		}
	}
}
