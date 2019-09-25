import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int count4 = (int) s.chars().filter(ch -> ch == '4').count();
		int count7 = (int) s.chars().filter(ch -> ch == '7').count();

		if (count4 == 0 && count7 == 0) {
			return -1;
		} else if (count4 >= count7) {
			return 4;
		} else {
			return 7;
		}
	}
}
