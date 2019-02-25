import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		String nStr = String.valueOf(n);
		int result = 0;
		for (int i = 0; i < nStr.length(); i++) {
			result = result * 2 + ((nStr.charAt(i) == '4') ? 1 : 2);
		}
		return result;
	}
}
