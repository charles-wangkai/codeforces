import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static String solve(String s) {
		boolean prevCouple = false;
		char currLetter = 0;
		int count = 0;
		StringBuilder result = new StringBuilder();
		for (char letter : s.toCharArray()) {
			if (letter == currLetter) {
				if (count == 2 || (count == 1 && prevCouple)) {
					continue;
				}

				result.append(letter);

				count++;
			} else {
				result.append(letter);

				prevCouple = count == 2;
				currLetter = letter;
				count = 1;
			}
		}

		return result.toString();
	}
}
