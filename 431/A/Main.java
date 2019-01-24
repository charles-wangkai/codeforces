import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] a = new int[4];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		String s = sc.next();
		System.out.println(solve(a, s));

		sc.close();
	}

	static int solve(int[] a, String s) {
		return s.chars().map(ch -> a[ch - '0' - 1]).sum();
	}
}
