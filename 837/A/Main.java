import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		List<String> words = new ArrayList<>();
		while (sc.hasNext()) {
			words.add(sc.next());
		}
		System.out.println(solve(words));

		sc.close();
	}

	static int solve(List<String> words) {
		return words.stream().mapToInt(word -> (int) word.chars().filter(Character::isUpperCase).count()).max()
				.getAsInt();
	}
}
