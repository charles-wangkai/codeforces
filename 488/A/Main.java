import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int a) {
		for (int i = 1;; i++) {
			if (isLucky(a + i)) {
				return i;
			}
		}
	}

	static boolean isLucky(int n) {
		return String.valueOf(n).chars().anyMatch(ch -> ch == '8');
	}
}
