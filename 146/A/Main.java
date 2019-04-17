import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String ticketNumber = sc.next();
		System.out.println(solve(ticketNumber) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String ticketNumber) {
		return ticketNumber.chars().allMatch(ch -> ch == '4' || ch == '7')
				&& IntStream.range(0, ticketNumber.length() / 2).map(i -> ticketNumber.charAt(i) - '0').sum()
						* 2 == ticketNumber.chars().map(ch -> ch - '0').sum();
	}
}
