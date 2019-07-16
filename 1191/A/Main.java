import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		System.out.println(solve(x));

		sc.close();
	}

	static String solve(int x) {
		int remainder = x % 4;
		if (remainder == 0) {
			return "1 A";
		} else if (remainder == 1) {
			return "0 A";
		} else if (remainder == 2) {
			return "1 B";
		} else {
			return "2 A";
		}
	}
}
