import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int m = sc.nextInt();
		int[] l = new int[m];
		int[] r = new int[m];
		int[] k = new int[m];
		for (int i = 0; i < m; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
			k[i] = sc.nextInt();
		}
		System.out.println(solve(s, l, r, k));

		sc.close();
	}

	static String solve(String s, int[] l, int[] r, int[] k) {
		for (int i = 0; i < l.length; i++) {
			s = shift(s, l[i] - 1, r[i] - 1, k[i] % (r[i] - l[i] + 1));
		}

		return s;
	}

	static String shift(String s, int leftIndex, int rightIndex, int count) {
		return String.format("%s%s%s%s", s.substring(0, leftIndex), s.substring(rightIndex - count + 1, rightIndex + 1),
				s.substring(leftIndex, rightIndex - count + 1), s.substring(rightIndex + 1));
	}
}
