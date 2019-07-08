import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int min = 0;
		int value = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '+') {
				value++;
			} else {
				value--;
			}

			min = Math.min(min, value);
		}

		return value - min;
	}
}
