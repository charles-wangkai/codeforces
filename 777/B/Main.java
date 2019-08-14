import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String card1 = sc.next();
		String card2 = sc.next();
		System.out.println(solve(card1, card2));

		sc.close();
	}

	static String solve(String card1, String card2) {
		return String.format("%d\n%d", computeMinGet(card1, card2), computeMaxGive(card1, card2));
	}

	static List<Integer> buildDigits(String card) {
		return card.chars().map(ch -> ch - '0').boxed().sorted().collect(Collectors.toList());
	}

	static int computeMinGet(String card1, String card2) {
		List<Integer> digits1 = buildDigits(card1);
		List<Integer> digits2 = buildDigits(card2);

		int result = 0;
		for (int digit1 : digits1) {
			if (digits2.get(digits2.size() - 1) >= digit1) {
				int index = digits2.size() - 1;
				while (index >= 1 && digits2.get(index - 1) >= digit1) {
					index--;
				}
				digits2.remove(index);
			} else {
				digits2.remove(0);

				result++;
			}
		}

		return result;
	}

	static int computeMaxGive(String card1, String card2) {
		List<Integer> digits1 = buildDigits(card1);
		List<Integer> digits2 = buildDigits(card2);

		int result = 0;
		for (int digit1 : digits1) {
			if (digits2.get(digits2.size() - 1) > digit1) {
				int index = digits2.size() - 1;
				while (index >= 1 && digits2.get(index - 1) > digit1) {
					index--;
				}
				digits2.remove(index);

				result++;
			} else {
				digits2.remove(0);
			}
		}

		return result;
	}
}
