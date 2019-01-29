import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String string = sc.next();
		System.out.println(solve(string));

		sc.close();
	}

	static int solve(String string) {
		String s = String.format("A%sA", string);
		int[] indices = IntStream.range(0, s.length()).filter(i -> isVowel(s.charAt(i))).toArray();

		return IntStream.range(0, indices.length - 1).map(i -> indices[i + 1] - indices[i]).max().getAsInt();
	}

	static boolean isVowel(char letter) {
		return "AEIOUY".indexOf(letter) >= 0;
	}
}
