import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		String q = sc.next();
		System.out.println(solve(k, q));

		sc.close();
	}

	static String solve(int k, String q) {
		int[] letters = q.chars().distinct().toArray();
		if (letters.length < k) {
			return "NO";
		}

		int[] indices = IntStream
				.concat(Arrays.stream(letters).map(q::indexOf).sorted().limit(k), IntStream.of(q.length())).toArray();

		return String.format("YES\n%s", IntStream.range(0, indices.length - 1)
				.mapToObj(i -> q.substring(indices[i], indices[i + 1])).collect(Collectors.joining("\n")));
	}
}
