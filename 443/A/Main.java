import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String set = sc.nextLine();
		System.out.println(solve(set));

		sc.close();
	}

	static int solve(String set) {
		return (int) Arrays.stream(set.substring(1, set.length() - 1).split(", ")).filter(x -> !x.isEmpty()).distinct()
				.count();
	}
}
