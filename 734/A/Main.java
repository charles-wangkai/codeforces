import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		int countA = (int) s.chars().filter(ch -> ch == 'A').count();
		int countD = (int) s.chars().filter(ch -> ch == 'D').count();

		if (countA < countD) {
			return "Danik";
		} else if (countA > countD) {
			return "Anton";
		} else {
			return "Friendship";
		}
	}
}
