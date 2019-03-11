import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int b = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[k];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(b, a));

		sc.close();
	}

	static String solve(int b, int[] a) {
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			result = (result + a[i] * ((i == a.length - 1) ? 1 : b)) % 2;
		}

		return (result == 0) ? "even" : "odd";
	}
}
