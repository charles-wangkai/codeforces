import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			sc.nextInt();
			String s = sc.next();

			System.out.println(solve(s));
		}

		sc.close();
	}

	static String solve(String s) {
		int indices[] = IntStream.range(0, s.length()).filter(i -> (s.charAt(i) - '0') % 2 != 0).toArray();

		return (indices.length >= 2) ? s.substring(indices[indices.length - 2], indices[indices.length - 1] + 1) : "-1";
	}
}
