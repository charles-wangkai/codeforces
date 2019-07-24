import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt1 = sc.nextInt();
		int cnt2 = sc.nextInt();
		int cnt3 = sc.nextInt();
		int cnt4 = sc.nextInt();
		System.out.println(solve(cnt1, cnt2, cnt3, cnt4) ? 1 : 0);

		sc.close();
	}

	static boolean solve(int cnt1, int cnt2, int cnt3, int cnt4) {
		return cnt1 == cnt4 && (cnt3 == 0 || cnt1 != 0);
	}
}
