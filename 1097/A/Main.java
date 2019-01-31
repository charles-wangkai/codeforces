import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String tableCard = sc.next();
		String[] handCards = new String[5];
		for (int i = 0; i < handCards.length; i++) {
			handCards[i] = sc.next();
		}
		System.out.println(solve(tableCard, handCards) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(String tableCard, String[] handCards) {
		return Arrays.stream(handCards)
				.anyMatch(handCard -> IntStream.range(0, 2).anyMatch(i -> tableCard.charAt(i) == handCard.charAt(i)));
	}
}
