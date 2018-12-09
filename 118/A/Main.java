import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		return String.join("", s.toLowerCase().replaceAll("[aoyeui]", "").chars()
				.mapToObj(ch -> String.format(".%c", ch)).toArray(String[]::new));
	}
}
