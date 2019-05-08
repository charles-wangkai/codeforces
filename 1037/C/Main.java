import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String a = sc.next();
		String b = sc.next();
		System.out.println(solve(a, b));

		sc.close();
	}

	static int solve(String a, String b) {
		int result = 0;
		int index = 0;
		while (index < a.length()) {
			if (a.charAt(index) != b.charAt(index)) {
				if (index + 1 < a.length() && a.charAt(index) != a.charAt(index + 1)
						&& a.charAt(index + 1) != b.charAt(index + 1)) {
					index += 2;
				} else {
					index++;
				}

				result++;
			} else {
				index++;
			}
		}
		return result;
	}
}
