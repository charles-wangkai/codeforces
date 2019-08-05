import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		String password = sc.next();
		System.out.print(solve(password, a, b));

		sc.close();
	}

	static String solve(String password, int a, int b) {
		if (a + b > password.length()) {
			return "-1";
		}

		int count0 = 0;
		int count1 = 0;
		for (char ch : password.toCharArray()) {
			if (ch == '0') {
				count0++;
			} else if (ch == '1') {
				count1++;
			}
		}

		int replaceCount01 = 0;
		int replaceCount02 = 0;
		int replaceCount10 = 0;
		int replaceCount12 = 0;
		int replaceCount20 = 0;
		int replaceCount21 = 0;

		while (count0 != a) {
			if (count0 < a) {
				if (count1 > b) {
					count1--;
					replaceCount10++;
				} else {
					replaceCount20++;
				}

				count0++;
			} else {
				if (count1 < b) {
					count1++;
					replaceCount01++;
				} else {
					replaceCount02++;
				}

				count0--;
			}
		}

		while (count1 != b) {
			if (count1 < b) {
				count1++;
				replaceCount21++;
			} else {
				count1--;
				replaceCount12++;
			}
		}

		int replaceCount = replaceCount01 + replaceCount02 + replaceCount10 + replaceCount12 + replaceCount20
				+ replaceCount21;

		StringBuilder changed = new StringBuilder();
		for (char ch : password.toCharArray()) {
			if (ch == '0') {
				if (replaceCount01 != 0) {
					changed.append(1);
					replaceCount01--;
				} else if (replaceCount02 != 0) {
					changed.append(2);
					replaceCount02--;
				} else {
					changed.append(0);
				}
			} else if (ch == '1') {
				if (replaceCount10 != 0) {
					changed.append(0);
					replaceCount10--;
				} else if (replaceCount12 != 0) {
					changed.append(2);
					replaceCount12--;
				} else {
					changed.append(1);
				}
			} else if (ch == '2') {
				if (replaceCount20 != 0) {
					changed.append(0);
					replaceCount20--;
				} else if (replaceCount21 != 0) {
					changed.append(1);
					replaceCount21--;
				} else {
					changed.append(2);
				}
			}
		}

		return String.format("%d\n%s", replaceCount, changed.toString());
	}
}
