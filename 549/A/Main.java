import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final String TARGET = "face";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] image = new char[n][m];
		for (int r = 0; r < n; r++) {
			String line = sc.next();
			for (int c = 0; c < m; c++) {
				image[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(image));

		sc.close();
	}

	static int solve(char[][] image) {
		return IntStream.range(0, image.length - 1).map(r -> (int) IntStream.range(0, image[0].length - 1)
				.filter(c -> generateKey(
						new String(new char[] { image[r][c], image[r][c + 1], image[r + 1][c], image[r + 1][c + 1] }))
								.equals(generateKey(TARGET)))
				.count()).sum();
	}

	static String generateKey(String s) {
		return s.chars().sorted().mapToObj(ch -> (char) ch)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}
}
