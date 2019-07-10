import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String ticket = sc.next();
		System.out.println(solve(ticket) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String ticket) {
		int[] sortedLeft = IntStream.range(0, ticket.length() / 2).map(i -> ticket.charAt(i) - '0').sorted().toArray();
		int[] sortedRight = IntStream.range(ticket.length() / 2, ticket.length()).map(i -> ticket.charAt(i) - '0')
				.sorted().toArray();

		return IntStream.range(0, sortedLeft.length).allMatch(i -> sortedLeft[i] < sortedRight[i])
				|| IntStream.range(0, sortedLeft.length).allMatch(i -> sortedLeft[i] > sortedRight[i]);
	}
}
