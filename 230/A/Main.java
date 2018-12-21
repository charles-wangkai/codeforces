import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int n = sc.nextInt();
		Dragon[] dragons = new Dragon[n];
		for (int i = 0; i < dragons.length; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			dragons[i] = new Dragon(x, y);
		}
		System.out.println(solve(s, dragons) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int s, Dragon[] dragons) {
		Arrays.sort(dragons, (dragon1, dragon2) -> Integer.compare(dragon1.x, dragon2.x));

		for (Dragon dragon : dragons) {
			if (s <= dragon.x) {
				return false;
			}

			s += dragon.y;
		}
		return true;
	}
}

class Dragon {
	int x;
	int y;

	Dragon(int x, int y) {
		this.x = x;
		this.y = y;
	}
}