import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		sc.nextLine();
		String[] text = new String[n];
		for (int i = 0; i < text.length; i++) {
			text[i] = sc.nextLine();
		}
		System.out.println(solve(p, text) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] p, String[] text) {
		return IntStream.range(0, p.length).allMatch(i -> text[i].replaceAll("[^aeiouy]", "").length() == p[i]);
	}
}
