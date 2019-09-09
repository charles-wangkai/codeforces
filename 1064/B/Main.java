import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int a = sc.nextInt();

			System.out.println(solve(a));
		}

		sc.close();
	}

	static int solve(int a) {
		return 1 << Integer.toBinaryString(a).chars().filter(ch -> ch == '1').count();
	}
}
