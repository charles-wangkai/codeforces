import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		return String.join(" ", Arrays.stream(s.split("WUB")).filter(word -> !word.isEmpty()).toArray(String[]::new));
	}
}
