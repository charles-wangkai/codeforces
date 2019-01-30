import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String coordinate = sc.next();

			System.out.println(solve(coordinate));
		}

		sc.close();
	}

	static String solve(String coordinate) {
		String[] stringParts = extract(coordinate, "\\d+");
		String[] numberParts = extract(coordinate, "\\p{Upper}+");

		if (numberParts.length == 1) {
			int rowNumber = Integer.parseInt(numberParts[0]);

			int colNumber = 0;
			for (char letter : stringParts[0].toCharArray()) {
				colNumber = colNumber * 26 + (letter - 'A' + 1);
			}

			return String.format("R%dC%d", rowNumber, colNumber);
		} else {
			int rowNumber = Integer.parseInt(numberParts[0]);
			int colNumber = Integer.parseInt(numberParts[1]);

			String colString = "";
			while (colNumber != 0) {
				colString = (char) ((colNumber - 1) % 26 + 'A') + colString;
				colNumber = (colNumber - 1) / 26;
			}

			return String.format("%s%d", colString, rowNumber);
		}
	}

	static String[] extract(String coordinate, String delimiterRegex) {
		return Arrays.stream(coordinate.split(delimiterRegex)).filter(part -> !part.isEmpty()).toArray(String[]::new);
	}
}
