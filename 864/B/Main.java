import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		return IntStream.range(0, s.length())
				.flatMap(i -> IntStream.rangeClosed(i, s.length())
						.filter(j -> s.substring(i, j).chars().allMatch(Character::isLowerCase))
						.map(j -> (int) s.substring(i, j).chars().distinct().count()))
				.max().orElse(0);
	}
}
