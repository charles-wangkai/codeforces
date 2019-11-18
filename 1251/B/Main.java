import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Q = sc.nextInt();
		for (int tc = 0; tc < Q; tc++) {
			int n = sc.nextInt();
			String[] s = new String[n];
			for (int i = 0; i < s.length; i++) {
				s[i] = sc.next();
			}

			System.out.println(solve(s));
		}

		sc.close();
	}

	static int solve(String[] s) {
		int count0 = 0;
		int count1 = 0;
		for (char ch : String.join("", s).toCharArray()) {
			if (ch == '0') {
				count0++;
			} else {
				count1++;
			}
		}

		if (count0 % 2 != 0 && count1 % 2 != 0 && Arrays.stream(s).allMatch(si -> si.length() % 2 == 0)) {
			return s.length - 1;
		} else {
			return s.length;
		}
	}
}
