import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		Queue<Integer> cards1 = readCards(sc);
		Queue<Integer> cards2 = readCards(sc);
		System.out.println(solve(cards1, cards2));

		sc.close();
	}

	static Queue<Integer> readCards(Scanner sc) {
		Queue<Integer> cards = new LinkedList<>();
		int size = sc.nextInt();
		for (int i = 0; i < size; i++) {
			cards.offer(sc.nextInt());
		}
		return cards;
	}

	static String solve(Queue<Integer> cards1, Queue<Integer> cards2) {
		Set<State> history = new HashSet<>();

		for (int fightNum = 1;; fightNum++) {
			State state = new State(cards1, cards2);
			if (history.contains(state)) {
				return "-1";
			}
			history.add(state);

			int top1 = cards1.poll();
			int top2 = cards2.poll();
			if (top1 < top2) {
				cards2.offer(top1);
				cards2.offer(top2);
			} else {
				cards1.offer(top2);
				cards1.offer(top1);
			}

			if (cards1.isEmpty()) {
				return String.format("%d 2", fightNum);
			} else if (cards2.isEmpty()) {
				return String.format("%d 1", fightNum);
			}
		}
	}
}

class State {
	Queue<Integer> cards1;
	Queue<Integer> cards2;

	State(Queue<Integer> cards1, Queue<Integer> cards2) {
		this.cards1 = new LinkedList<>(cards1);
		this.cards2 = new LinkedList<>(cards2);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cards1, cards2);
	}

	@Override
	public boolean equals(Object obj) {
		State other = (State) obj;
		return Objects.equals(cards1, other.cards1) && Objects.equals(cards2, other.cards2);
	}
}