import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int b = sc.nextInt();
		int a = sc.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}
		System.out.println(solve(s, b, a));

		sc.close();
	}

	static int solve(int[] s, int b, int a) {
		int chargeB = b;
		int chargeA = a;
		for (int i = 0; i < s.length; i++) {
			if (chargeB == 0 && chargeA == 0) {
				return i;
			}

			if (s[i] == 0) {
				if (chargeA != 0) {
					chargeA--;
				} else {
					chargeB--;
				}
			} else {
				if (chargeB != 0 && chargeA != a) {
					chargeB--;
					chargeA++;
				} else {
					chargeA--;
				}
			}
		}

		return s.length;
	}
}
