import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String cell = sc.next();
		System.out.println(solve(cell));

		sc.close();
	}

	static int solve(String cell) {
		int firstZeroIndex = cell.indexOf('0');

		return (firstZeroIndex >= 0) ? (firstZeroIndex + 1) : cell.length();
	}
}
