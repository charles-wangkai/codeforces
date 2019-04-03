import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String days = sc.next();
		System.out.println(solve(days) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String days) {
		int sfCount = 0;
		int fsCount = 0;
		for (int i = 0; i < days.length() - 1; i++) {
			if (days.charAt(i) != days.charAt(i + 1)) {
				if (days.charAt(i) == 'S') {
					sfCount++;
				} else {
					fsCount++;
				}
			}
		}
		return sfCount > fsCount;
	}
}
