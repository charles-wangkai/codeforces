import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		return (s.length() > 26) ? -1 : (s.length() - s.chars().boxed().collect(Collectors.toSet()).size());
	}
}
