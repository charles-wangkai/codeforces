import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		int count0 = 0;
		int count5 = 0;
		for (int ai : a) {
			if (ai == 0) {
				count0++;
			} else if (ai == 5) {
				count5++;
			}
		}

		return (count0 == 0) ? "-1"
				: String.format("%s%s", repeat('5', count5 / 9 * 9), repeat('0', (count5 >= 9) ? count0 : 1));
	}

	static String repeat(char ch, int count) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < count; i++) {
			result.append(ch);
		}
		return result.toString();
	}
}
