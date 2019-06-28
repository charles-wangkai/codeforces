import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int a) {
		for (int i = a;; i++) {
			if (String.valueOf(i).chars().map(ch -> ch - '0').sum() % 4 == 0) {
				return i;
			}
		}
	}
}
