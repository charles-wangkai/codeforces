import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		String[] passwords = new String[n];
		for (int i = 0; i < passwords.length; i++) {
			passwords[i] = sc.next();
		}
		String correct = sc.next();
		System.out.println(solve(passwords, k, correct));

		sc.close();
	}

	static String solve(String[] passwords, int k, String correct) {
		int lessLengthNum = (int) Arrays.stream(passwords).filter(password -> password.length() < correct.length())
				.count();
		int sameLengthNum = (int) Arrays.stream(passwords).filter(password -> password.length() == correct.length())
				.count();

		return String.format("%d %d", computeTime(k, lessLengthNum), computeTime(k, lessLengthNum + sameLengthNum - 1));
	}

	static int computeTime(int k, int beforeNum) {
		return beforeNum + beforeNum / k * 5 + 1;
	}
}
