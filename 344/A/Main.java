import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] magnets = new String[n];
		for (int i = 0; i < magnets.length; i++) {
			magnets[i] = sc.next();
		}
		System.out.println(solve(magnets));

		sc.close();
	}

	static int solve(String[] magnets) {
		return (int) IntStream.range(0, magnets.length - 1).filter(i -> !magnets[i].equals(magnets[i + 1])).count() + 1;
	}
}
