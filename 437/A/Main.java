import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] descriptions = new String[4];
		for (int i = 0; i < descriptions.length; i++) {
			descriptions[i] = sc.next().substring(2);
		}
		System.out.println(solve(descriptions));

		sc.close();
	}

	static char solve(String[] descriptions) {
		int[] candidateIndices = IntStream.range(0, descriptions.length)
				.filter(i -> IntStream.range(0, descriptions.length)
						.allMatch(j -> j == i || descriptions[j].length() >= descriptions[i].length() * 2)
						|| IntStream.range(0, descriptions.length)
								.allMatch(j -> j == i || descriptions[j].length() * 2 <= descriptions[i].length()))
				.toArray();

		return (candidateIndices.length == 1) ? (char) (candidateIndices[0] + 'A') : 'C';
	}
}
