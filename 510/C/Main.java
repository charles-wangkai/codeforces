import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int SIZE = 26;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] names = new String[n];
		for (int i = 0; i < names.length; i++) {
			names[i] = sc.next();
		}
		System.out.println(solve(names));

		sc.close();
	}

	static String solve(String[] names) {
		boolean[][] relations = new boolean[SIZE][SIZE];
		for (int i = 0; i < names.length - 1; i++) {
			int diffIndex = 0;
			while (diffIndex < names[i].length() && diffIndex < names[i + 1].length()
					&& names[i].charAt(diffIndex) == names[i + 1].charAt(diffIndex)) {
				diffIndex++;
			}

			if (diffIndex == names[i + 1].length()) {
				return "Impossible";
			}

			if (diffIndex != names[i].length()) {
				relations[names[i + 1].charAt(diffIndex) - 'a'][names[i].charAt(diffIndex) - 'a'] = true;
			}
		}

		for (int k = 0; k < SIZE; k++) {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (relations[i][k] && relations[k][j]) {
						relations[i][j] = true;
					}
				}
			}
		}

		if (IntStream.range(0, SIZE).anyMatch(i -> relations[i][i])) {
			return "Impossible";
		}

		int[] lessCounts = IntStream.range(0, SIZE)
				.map(i -> (int) IntStream.range(0, SIZE).filter(j -> relations[i][j]).count()).toArray();

		return IntStream.range(0, SIZE).boxed()
				.sorted((index1, index2) -> Integer.compare(lessCounts[index1], lessCounts[index2]))
				.map(index -> (char) (index + 'a'))
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
