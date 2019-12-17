import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			String s = sc.next();

			System.out.println(solve(s));
		}

		sc.close();
	}

	static String solve(String s) {
		if (s.endsWith("po")) {
			return "FILIPINO";
		} else if (s.endsWith("mnida")) {
			return "KOREAN";
		} else {
			return "JAPANESE";
		}
	}
}
