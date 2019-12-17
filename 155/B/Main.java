import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Card[] cards = new Card[n];
		for (int i = 0; i < cards.length; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			cards[i] = new Card(a, b);
		}
		System.out.println(solve(cards));

		sc.close();
	}

	static int solve(Card[] cards) {
		Arrays.sort(cards, (c1, c2) -> (c1.b != c2.b) ? -Integer.compare(c1.b, c2.b) : -Integer.compare(c1.a, c2.a));

		int result = 0;
		int counter = 1;
		for (Card card : cards) {
			if (counter == 0) {
				break;
			}
			counter += card.b - 1;

			result += card.a;
		}

		return result;
	}
}

class Card {
	int a;
	int b;

	Card(int a, int b) {
		this.a = a;
		this.b = b;
	}
}