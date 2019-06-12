import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] phrases = new String[M];
		for (int i = 0; i < phrases.length; i++) {
			phrases[i] = sc.next();
		}
		System.out.println(solve(N, phrases));

		sc.close();
	}

	static String solve(int N, String[] phrases) {
		return phrases[(N - 1) % phrases.length];
	}
}
