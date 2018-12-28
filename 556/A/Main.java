import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		return Math.abs(count(s, '0') - count(s, '1'));
	}

	static int count(String s, char target) {
		return (int) s.chars().filter(ch -> ch == target).count();
	}
}
